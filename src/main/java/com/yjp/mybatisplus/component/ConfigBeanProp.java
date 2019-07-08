package com.yjp.mybatisplus.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "demo")
//@PropertySource(value = "config.properties")
@Data
public class ConfigBeanProp {
	private String phone;
	private String wife;
}
