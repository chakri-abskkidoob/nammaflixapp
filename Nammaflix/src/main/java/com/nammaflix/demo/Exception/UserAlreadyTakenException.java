package com.nammaflix.demo.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyTakenException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyTakenException(String message) {
		super(message);
	}
}
