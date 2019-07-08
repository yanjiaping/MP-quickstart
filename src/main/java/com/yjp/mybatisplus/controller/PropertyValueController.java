package com.yjp.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.mybatisplus.component.ConfigBeanProp;
import com.yjp.mybatisplus.component.ConfigBeanValue;

@RestController
public class PropertyValueController {
//	@Value("${server.port}")
//	private String port;
//	@Value("${server.servlet.context-path}")
//	private String contextPath;
//
//	@GetMapping(value = "/propertyValue")
//	public String propertyValue() {
//		return "get properties value by '@Value' :" +
//        //1、使用@Value注解读取
//        " port=" + port +
//        " , contextPath=" + contextPath;
//	}
	
	@Autowired
	private ConfigBeanValue configBeanValue;
	@Autowired
	private Environment environment;
	@Autowired
    private ConfigBeanProp configBeanProp;
	
	@GetMapping(value = "/propertyValue")
	public String propertyValue() {
		return "get properties value by '@Value' :" +
        //1、使用@Value注解读取
        " port=" + configBeanValue.getPort() +
        " , contextPath=" + configBeanValue.getContextPath() +
        "<p>get properties value by 'Environment' :" +
        //2、使用Environment读取
        " , driverClassName=" + environment.getProperty("spring.datasource.druid.driver-class-name") +
        " , url=" + environment.getProperty("spring.datasource.druid.url") +
        "<p>get properties value by ''@ConfigurationProperties'' :" +
        //3、使用@ConfigurationProperties注解读取
        " phone=" + configBeanProp.getPhone() +
        " , wife=" + configBeanProp.getWife();
	}
	

}
