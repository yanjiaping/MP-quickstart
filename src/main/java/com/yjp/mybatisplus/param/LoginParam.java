package com.yjp.mybatisplus.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginParam {
	@NotBlank
	private String loginName;
	@NotBlank
	private String password;
}
