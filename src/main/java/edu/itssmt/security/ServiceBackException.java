package edu.itssmt.security;

import org.springframework.security.core.AuthenticationException;

public class ServiceBackException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceBackException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceBackException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

}
