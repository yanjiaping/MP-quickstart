package com.yjp.mybatisplus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yjp.mybatisplus.interceptor.HttpInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	@Autowired
	private HttpInterceptor httpInterceptor;

	// 注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(httpInterceptor).addPathPatterns("/**").excludePathPatterns("/tb/login/userLogin", "/propertyValue");
	}

}
