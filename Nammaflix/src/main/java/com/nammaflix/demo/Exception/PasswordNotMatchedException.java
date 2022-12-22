package com.nammaflix.demo.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordNotMatchedException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordNotMatchedException(String message){
		super(message); 
	}
}
