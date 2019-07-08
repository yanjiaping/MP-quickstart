package com.yjp.mybatisplus.exception;

public class UserLoginException extends BaseException {

	private static final long serialVersionUID = 1L;

	public UserLoginException(Integer code, String msg) {
		super(code, msg);
	}
}
