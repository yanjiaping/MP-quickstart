package com.yjp.mybatisplus.core;

import lombok.Data;

@Data
public class Result {
	private Integer code;
	private String msg;
	private Object info;

	public static Result quickOK(Object info) {
		Result result = new Result();
		result.code = 0;
		result.msg = "OK";
		result.info = info;
		return result;
	}

	public static Result quickOK() {
		Result result = new Result();
		result.code = 0;
		result.msg = "OK";
		result.info = null;
		return result;
	}
}
