package com.yjp.mybatisplus.service.tb;

import org.springframework.http.HttpHeaders;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjp.mybatisplus.core.AuthorizedUser;
import com.yjp.mybatisplus.entity.tb.Login;
import com.yjp.mybatisplus.param.LoginParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yanjiaping
 * @since 2019-04-26
 */
public interface ILoginService extends IService<Login> {
	AuthorizedUser userLogin(HttpHeaders headers, LoginParam loginParam);
	
	String userLogout(HttpHeaders headers);
}
