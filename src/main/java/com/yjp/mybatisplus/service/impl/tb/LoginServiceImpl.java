package com.yjp.mybatisplus.service.impl.tb;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjp.mybatisplus.constant.ErrorEnum;
import com.yjp.mybatisplus.core.AuthorizedUser;
import com.yjp.mybatisplus.entity.tb.Login;
import com.yjp.mybatisplus.entity.tb.LoginLog;
import com.yjp.mybatisplus.entity.tb.User;
import com.yjp.mybatisplus.exception.HttpTokenException;
import com.yjp.mybatisplus.exception.UserLoginException;
import com.yjp.mybatisplus.mapper.redis.UserRedisMapper;
import com.yjp.mybatisplus.mapper.tb.LoginLogMapper;
import com.yjp.mybatisplus.mapper.tb.LoginMapper;
import com.yjp.mybatisplus.mapper.tb.UserMapper;
import com.yjp.mybatisplus.param.LoginParam;
import com.yjp.mybatisplus.service.tb.ILoginService;
import com.yjp.mybatisplus.util.PasswordUtil;
import com.yjp.mybatisplus.util.UUIDUtil;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-26
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {
	private static final Long REDIS_EXPRIE_TIME = 3600L;

	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private UserRedisMapper userRedisMapper;
	@Autowired
	private LoginLogMapper loginLogMapper;
	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public AuthorizedUser userLogin(HttpHeaders headers, LoginParam loginParam) {
		AuthorizedUser authorizedUser = loginCommonLogic(loginParam.getLoginName(), loginParam.getPassword());
		// 生成令牌
		String token = "WEB:" + UUIDUtil.generate32UUID();
		authorizedUser.setToken(token);
		// 放入缓存
		userRedisMapper.setAuthorizedUser(token, authorizedUser, REDIS_EXPRIE_TIME);
		// 插入登录日志表
		LoginLog loginLog = new LoginLog();
		loginLog.setLoginId(authorizedUser.getLogin().getLoginId());
		loginLogMapper.insert(loginLog);
		return authorizedUser;
	}

	/**
	 * 通用登陆逻辑
	 */
	public AuthorizedUser loginCommonLogic(String loginName, String password) {
		// 账号是否存在
		Login loginEntityFromDB = loginMapper.selectOne(new QueryWrapper<Login>().eq("login_name", loginName));
		if (loginEntityFromDB != null) {
			// 判断该账号是否锁定
			if (StringUtils.equals(loginEntityFromDB.getValidStatus(), "N")) {
				throw new UserLoginException(ErrorEnum.ERROR_ACCOUNT_STATUS_EXCEPTION.getCode(),
						ErrorEnum.ERROR_ACCOUNT_STATUS_EXCEPTION.getDefaultMsg());
			}
			String passwordFromDB = loginEntityFromDB.getPassword();
			if (StringUtils.equals(PasswordUtil.toHash(password).toUpperCase(), passwordFromDB)) {
				User user = userMapper
						.selectOne(Wrappers.<User>lambdaQuery().eq(User::getLoginId, loginEntityFromDB.getLoginId()));
				// 生成最终用户信息
				AuthorizedUser authorizedUser = new AuthorizedUser();
				authorizedUser.setExprie(REDIS_EXPRIE_TIME);
				authorizedUser.setLoginDate(new Date());
				authorizedUser.setLogin(loginEntityFromDB);
				authorizedUser.setUser(user);
				return authorizedUser;
			} else {
				throw new UserLoginException(ErrorEnum.ERROR_ACCOUNT_EXCEPTION.getCode(),
						ErrorEnum.ERROR_ACCOUNT_EXCEPTION.getDefaultMsg());
			}
		} else {
			throw new UserLoginException(ErrorEnum.ERROR_ACCOUNT_EXCEPTION.getCode(),
					ErrorEnum.ERROR_ACCOUNT_EXCEPTION.getDefaultMsg());
		}
	}

	/**
	 * 用户注销（登出）
	 */
	@Transactional
	@Override
	public String userLogout(HttpHeaders headers) {
		if (StringUtils.isBlank(headers.getFirst("Authorization"))) {
			throw new HttpTokenException();
		} else {
			String token = headers.getFirst("Authorization");
			AuthorizedUser authorizedUser = userRedisMapper.getAuthorizedUser(token);
			if (authorizedUser != null) {
				userRedisMapper.removeAuthorizedUser(token);// 删除用户缓存信息
			}
			// 插入登录日志表
			LoginLog loginLog = new LoginLog();
			loginLog.setLoginId(authorizedUser.getLogin().getLoginId());
			loginLog.setAction("LOGOUT");
			loginLogMapper.insert(loginLog);
		}
		return "登出成功";

	}

}
