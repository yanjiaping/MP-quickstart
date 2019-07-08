package com.yjp.mybatisplus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjp.mybatisplus.core.AuthorizedUser;
import com.yjp.mybatisplus.exception.HttpTokenException;
import com.yjp.mybatisplus.mapper.redis.UserRedisMapper;

/**
 * 自定义http请求拦截器
 * 
 * @author YJP
 *
 */
@Component
public class HttpInterceptor implements HandlerInterceptor {
	@Autowired
	private UserRedisMapper userRedisMapper;

	// 在一个请求进入Controller层方法执行前执行这个方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 在这里可以对参数做一些预处理和做一些验证
		System.out.println("----------执行拦截器preHandle()方法----------");
		
		String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token)) {
            AuthorizedUser authorizedUser = userRedisMapper.getAuthorizedUser(token);
            if (authorizedUser != null && authorizedUser.getUser().getUserId() != null) {
                return true;
            } else {
                throw new HttpTokenException();
            }
        }
        throw new HttpTokenException();
        
		// 方法给予执行，就是允许controller的方法进行执行
	}

	// 返回model前
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller执行完毕后，返回之前，可以对request和response进行处理
		// 如果是前后端没有分离，在进入View层中前执行
		System.out.println("----------执行拦截器postHandle()方法----------");
	}

	// 返回model后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 在一个请求处理完毕，即将销毁的时候，执行，可以做一些资源释放之类的工作
		System.out.println("----------执行拦截器afterCompletion()方法----------");
	}

}
