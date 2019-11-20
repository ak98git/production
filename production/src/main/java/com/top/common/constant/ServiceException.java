package com.top.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author vae
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** 错误编码  */
	private String code;

	/** 错误信息  */
	private String message;
	
	public ServiceException(RespCodeEnum respCodeEnum) {
		super();
		this.code = respCodeEnum.getCode();
		this.message = respCodeEnum.getMessage();
	}
	
	public ServiceException(RespCodeEnum respCodeEnum, String message) {
		super();
		this.code = respCodeEnum.getCode();
		this.message = StringUtils.isBlank(message)?respCodeEnum.getMessage():message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
