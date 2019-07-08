package com.yjp.mybatisplus.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ConfigBeanValue {
	@Value("${server.port}")
	private String port;
	@Value("${server.servlet.context-path}")
	private String contextPath;
}
