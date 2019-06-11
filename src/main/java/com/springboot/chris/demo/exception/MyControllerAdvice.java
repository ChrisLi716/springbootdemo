package com.springboot.chris.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyException {
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, String> errorHandler(Exception exception) {
		Map<String, String> exceptions = new HashMap<>();
		exceptions.put("code", "-1");
		exceptions.put("msg", exception.getMessage());
		return exceptions;
	}
}
