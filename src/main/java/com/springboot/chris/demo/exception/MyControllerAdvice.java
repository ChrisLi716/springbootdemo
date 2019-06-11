package com.springboot.chris.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, String> errorHandler(Exception exception) {
		Map<String, String> exceptions = new HashMap<>();
		exceptions.put("code", "-1");
		exceptions.put("msg", exception.getMessage());
		return exceptions;
	}
	
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public Map<String, String> bizErrorHandler(BusinessException bizException) {
		Map<String, String> exceptions = new HashMap<>();
		exceptions.put("code", bizException.getCode());
		exceptions.put("msg", bizException.getMsg());
		return exceptions;
	}
}
