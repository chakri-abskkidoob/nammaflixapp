package com.nammaflix.demo.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MismatchException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MismatchException(String message) {
		super(message);
	}
}
