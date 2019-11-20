package com.top.util;

import com.top.common.constant.BaseConstants;
import com.top.common.constant.RespCodeEnum;

import java.util.HashMap;
import java.util.Map;


/**
 * 响应接口的通用map结构实体类
 * @author scofreld
 */
public class ResultMap extends HashMap<String, Object>{

	private static final long serialVersionUID = 1L;
	
	public static Map<String, Object> buildErrorMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_HANDLE_TIPS.getCode());
		map.put(BaseConstants.SYS_RESP_MESSAGE_NAME, RespCodeEnum.SYS_HANDLE_TIPS.getMessage());
		map.put("data", null);
		return map;
	}
	
	public static Map<String, Object> buildErrorMap(String errorMsg){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_HANDLE_TIPS.getCode());
		map.put(BaseConstants.SYS_RESP_MESSAGE_NAME, errorMsg);
		map.put("data", null);
		return map;
	}
	
	public static Map<String, Object> buildSuccessMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_SUCCESS.getCode());
		map.put(BaseConstants.SYS_RESP_MESSAGE_NAME, RespCodeEnum.SYS_SUCCESS.getMessage());
		map.put("data", null);
		return map;
	}

	/**
	 * 创建基础结果map
	 * @param flag true构造成功的，false构造失败
	 */
	public ResultMap(boolean flag){
		if (flag) {
			this.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_SUCCESS.getCode());
			this.put(BaseConstants.SYS_RESP_MESSAGE_NAME, RespCodeEnum.SYS_SUCCESS.getMessage());
		}else {
			this.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_HANDLE_TIPS.getCode());
			this.put(BaseConstants.SYS_RESP_MESSAGE_NAME, RespCodeEnum.SYS_HANDLE_TIPS.getMessage());
		}
	}
	
	/**
	 * 默认响应成功的结果状态和数据
	 * @param data
	 */
	public ResultMap(Object data){
		this.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_SUCCESS.getCode());
		this.put(BaseConstants.SYS_RESP_MESSAGE_NAME, RespCodeEnum.SYS_SUCCESS.getMessage());
		this.put("data", data);
	}

	public ResultMap(boolean flag, String message){
		if (flag) {
			this.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_SUCCESS.getCode());
			this.put(BaseConstants.SYS_RESP_MESSAGE_NAME,message);
		}else {
			this.put(BaseConstants.SYS_RESP_CODE_NAME, RespCodeEnum.SYS_HANDLE_TIPS.getCode());
			this.put(BaseConstants.SYS_RESP_MESSAGE_NAME,message);
		}
	}
	
	public ResultMap(String code, String message){
		this.put(BaseConstants.SYS_RESP_CODE_NAME, code);
		this.put(BaseConstants.SYS_RESP_MESSAGE_NAME,message);
	}
	
	public ResultMap(RespCodeEnum respCodeEnum){
		this.put(BaseConstants.SYS_RESP_CODE_NAME, respCodeEnum.getCode());
		this.put(BaseConstants.SYS_RESP_MESSAGE_NAME, respCodeEnum.getMessage());
	}

	/**
	 * 设置响应状态码，默认key为code
	 * @param code
	 */
	public void putCode(String code){
		this.put(BaseConstants.SYS_RESP_CODE_NAME, code);
	}

	/**
	 * 设置响应信息，默认key为message
	 * @param message
	 */
	public void putMessage(String message){
		this.put(BaseConstants.SYS_RESP_MESSAGE_NAME, message);
	}

}
