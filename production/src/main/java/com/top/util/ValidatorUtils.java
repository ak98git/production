package com.top.util;

import com.alibaba.fastjson.JSONObject;
import com.top.common.constant.RespCodeEnum;
import com.top.common.constant.ServiceException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidatorUtils {

	public static void StringNotEmpty(String str, String msg) {
		if(StringUtils.isBlank(str)){
			throw new ServiceException(RespCodeEnum.SYS_REQPARAM_ERROR, msg);
		}
	}

	public static void ObjectNotNull(Object obj, String msg) {
		if(null==obj){
			throw new ServiceException(RespCodeEnum.SYS_REQPARAM_ERROR, msg);
		}
	}

	public static void JsonHasKey(String json,String key, String msg) {
		JSONObject jsonObject = JSONObject.parseObject(json);
		if(!jsonObject.containsKey(key)){
			throw new ServiceException(RespCodeEnum.SYS_REQPARAM_ERROR, msg);
		}
	}

	public static void ObjectIsNull(Object obj, String msg) {
		if(null!=obj){
			throw new ServiceException(RespCodeEnum.SYS_REQPARAM_ERROR, msg);
		}
	}
	
	public static void StringValueEquals(String value1, String value2, String msg) {
		if(StringUtils.isBlank(value1) || StringUtils.isBlank(value2) || !value1.equals(value2)){
			throw new ServiceException(RespCodeEnum.SYS_REQPARAM_ERROR, msg);
		}
	}
	
	public static <T> void validate(T obj){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			throw new ServiceException(RespCodeEnum.SYS_REQPARAM_ERROR, constraintViolation.getMessage());
		}
	}

}
