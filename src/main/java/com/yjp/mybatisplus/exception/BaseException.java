package com.yjp.mybatisplus.exception;

import org.apache.commons.lang3.StringUtils;

import com.yjp.mybatisplus.constant.ErrorEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer code;// 错误编码(用户自定义)
	private String msg;// 错误信息描述(用户自定义)

	/**
	 * 传入已定义
	 * */
	public BaseException(ErrorEnum errorEnum, String msg){
		this.code = errorEnum.getCode();
		if(StringUtils.isNotBlank(msg)){
			this.msg = msg;
		}else{
			this.msg = errorEnum.getDefaultMsg();
		}
	}

	public BaseException(Integer code, String msg){
		if(code == null){
			this.code = ErrorEnum.ERROR_SYSTEM_EXCEPTION.getCode();
		}else{
			this.code = code;
		}
		this.msg = msg;
	}

}
