package com.company.com.exception;

public class TableNotFoundException extends RuntimeException {
	
	public TableNotFoundException(String exceptionmsg) {
		super(exceptionmsg);
	}

}
