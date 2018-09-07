package com.appsdeveloperblog.mongotemplatedemo.controller;

public class PersionNotFoundException extends RuntimeException {
String msg;
	public PersionNotFoundException() {
		
	}

	public PersionNotFoundException(String msg) {
	this.msg=msg;
	}

	 public String getMessage() {
	        return msg;
	    }


}
