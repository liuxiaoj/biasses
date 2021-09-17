package com.bi.feapp.common.exception;

/**
 * @class InitialException
 * @description Initial Exception
 */

public class InitialException extends Exception {

	/**
	 * Auto generated serial version UID
	 */
	private static final long serialVersionUID = -9083365996508057987L;
	
	public InitialException(String message) {
		super(message);
	}
	
	public InitialException(Exception e) {
		super(e);
	}
	
	public InitialException(String message, Throwable t)
	{
		super(message, t);
	}
}
