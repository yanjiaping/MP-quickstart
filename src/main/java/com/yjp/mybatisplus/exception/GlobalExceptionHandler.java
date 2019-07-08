package com.yjp.mybatisplus.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yjp.mybatisplus.constant.ErrorEnum;
import com.yjp.mybatisplus.core.Result;

//@ControllerAdvice(basePackages={"com.xxx","com.ooo"})
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 默认异常处理
	 */
	@ExceptionHandler(Exception.class)
	// @ExceptionHandler//处理所有异常
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public Result exceptionHandler(HttpServletRequest request, Exception e) {
		// e.printStackTrace();
		logger.error("系统异常！", e);
		Result result = new Result();
		result.setCode(ErrorEnum.ERROR_SYSTEM_EXCEPTION.getCode());
		result.setMsg(ErrorEnum.ERROR_SYSTEM_EXCEPTION.getDefaultMsg());
		result.setInfo(e.toString());
		return result;
	}

	/**
	 * HTTP请求参数异常处理
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public Result httpParamExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
		e.printStackTrace();
		logger.error("Http参数异常！", e);
		Result result = new Result();
		result.setCode(ErrorEnum.ERROR_PARAM_ILLEGAL.getCode());
		result.setMsg(ErrorEnum.ERROR_PARAM_ILLEGAL.getDefaultMsg());
		result.setInfo(e.toString());
		return result;
	}

	/**
	 * HTTP请求类型异常处理
	 */
	@ExceptionHandler(ServletException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public Result servletExceptionHandler(HttpServletRequest request, ServletException e) {
		e.printStackTrace();
		logger.error("Http请求方式错误！", e);
		Result result = new Result();
		result.setCode(ErrorEnum.ERROR_HTTP_EXCEPTION.getCode());
		result.setMsg(ErrorEnum.ERROR_HTTP_EXCEPTION.getDefaultMsg());
		result.setInfo(e.toString());
		return result;
	}

	/**
	 * 系统自定义异常处理
	 */
	@ExceptionHandler(value = { BaseException.class })
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public Result appExceptionHandler(HttpServletRequest request, BaseException e) {
		e.printStackTrace();
		logger.error("业务异常！", e);
		Result result = new Result();
		result.setCode(e.getCode());
		result.setMsg(e.getMsg());
		result.setInfo(e.getStackTrace());
		return result;
	}
}