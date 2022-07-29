package com.example.demo.exception;

public class ReservationAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReservationAlreadyExistException(String msg) {
	super(msg);
	}

}
