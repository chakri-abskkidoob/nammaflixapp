package com.nammaflix.demo.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LogInException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogInException(String message) {
		super(message);
	}
}
