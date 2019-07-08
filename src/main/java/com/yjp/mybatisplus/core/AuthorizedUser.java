package com.yjp.mybatisplus.core;

import java.util.Date;

import com.yjp.mybatisplus.entity.tb.Login;
import com.yjp.mybatisplus.entity.tb.User;

import lombok.Data;

@Data
public class AuthorizedUser {
	// 令牌
	private String token;
	// 登陆时间
	private Date loginDate;
	/** 过期时间 */
	private Long exprie;
	/** 登陆用户信息 */
	private Login login;
	/** 登陆用户信息 */
	private User user;
}
