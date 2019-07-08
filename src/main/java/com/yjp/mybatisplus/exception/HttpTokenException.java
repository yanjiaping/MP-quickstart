package com.yjp.mybatisplus.exception;

import com.yjp.mybatisplus.constant.ErrorEnum;

public class HttpTokenException extends BaseException {
	private static final long serialVersionUID = 1L;

	public HttpTokenException() {
		super(ErrorEnum.ERROR_TOKEN_ILLEGAL, null);
	}
}
