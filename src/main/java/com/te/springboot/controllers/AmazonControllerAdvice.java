package com.te.springboot.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.te.springboot.bean.AmazonResponse;
import com.te.springboot.customexception.AmazonException;

@RestControllerAdvice
public class AmazonControllerAdvice {
	
	@ExceptionHandler(AmazonException.class)
	public AmazonResponse exceptionHandler(AmazonException exception) {
		AmazonResponse response = new AmazonResponse();
		response.setStatusCode(500);
		response.setMessage(exception.getMessage());
		return response;
	}
}
