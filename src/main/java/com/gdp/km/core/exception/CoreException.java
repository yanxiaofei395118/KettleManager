package com.gdp.km.core.exception;

public class CoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CoreException(){
		super();
	}
	
	public CoreException(String message){
		super(message);
	}
}
