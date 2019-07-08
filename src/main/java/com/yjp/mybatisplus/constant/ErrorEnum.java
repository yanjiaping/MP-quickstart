package com.yjp.mybatisplus.constant;

import org.apache.commons.lang3.StringUtils;

import com.yjp.mybatisplus.core.Result;

/**
 * 错误信息枚举类型
 * -默认错误信息设定
 * 
 * @author xuezhiyu
 *
 */

public enum ErrorEnum {
	ERROR_SYSTEM_EXCEPTION(101001,"系统异常，请稍后再试"),
	ERROR_PROPERTIES_COPY(101002,"系统异常，propertiesCopy操作失败"),
	ERROR_TOKEN_ILLEGAL(102001,"非法请求"),
	ERROR_TOKEN_TIMEOUT(102002,"请求失效"),
	ERROR_ACCOUNT_EXCEPTION(103001,"用户或密码错误"),//无论账号还是密码都报此错误
	ERROR_ROLE_EXCEPTION(103002,"用户角色异常"),
	ERROR_ACCOUNT_ISLOCK_EXCEPTION(103003,"该账户已被锁定，请联系管理员"),
	ERROR_ACCOUNT_STATUS_EXCEPTION(103004,"该账户已被禁用，请联系管理员"),
	ERROR_AUTH_ILLEGAL(103005,"当前用户权限非法"),
	ERROR_HTTP_EXCEPTION(104001,"请求异常"),
	ERROR_PARAM_ILLEGAL(104002,"存在非法参数"),
	ERROR_BUSINESS_ILLEGAL(104003,"非法的业务操作"),
	ERROR_UPLOADFILE_EXCEPTION(104004,"上传文件异常"),
	ERROR_DOWNLOADFILE_EXCEPTION(104005,"下载文件异常"),
	ERROR_WECHAT_BIND_EXCEPTION(104006,"获取微信用户绑定信息失败"),
	ERROR_WECHAT_ALREADY_BOUND_EXCEPTION(104007,"微信用户已绑定，解绑后才能再次绑定"),
	ERROR_WECHAT_DID_NOT_BOUND_EXCEPTION(104008,"微信用户未绑定过账户，请先绑定"),
	ERROR_TASK_EXCEPTION(105001,"定时任务异常"),
	ERROR_HTTP_LESHUI_EXCEPTION(106001,"乐税接口异常"),
	ERROR_WECHAT_EXCEPTION(106002,"微信异常"),
	ERROR_ALIYUN_EXCEPTION(106004,"阿里云异常");
	
	private final Integer code;//错误编码
	private final String defaultMsg;//错误描述，调用方不传入错误描述时，该描述默认使用
	
	private ErrorEnum(Integer code, String defaultMsg){
		this.code = code;
		this.defaultMsg = defaultMsg;
	}

	public Integer getCode() {
		return code;
	}

	public String getDefaultMsg() {
		return defaultMsg;
	}

	/**
	 * 传入枚举值返回result对象
	 * @param msg 传入错误中文描述
	 * */
	public Result generateResult(String msg){
		Result result = new Result();
		Integer code = this.getCode();
		String defaultMsg = this.getDefaultMsg();
		result.setCode(code);
		if(StringUtils.isNotBlank(msg)){
			result.setMsg(msg);
		}else{
			result.setMsg(defaultMsg);
		}
		return result;
	}
}
