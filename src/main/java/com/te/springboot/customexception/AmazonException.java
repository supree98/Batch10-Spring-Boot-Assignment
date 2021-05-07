package com.te.springboot.customexception;

public class AmazonException extends RuntimeException{

	public AmazonException(String message) {
		super(message);
	}
}
