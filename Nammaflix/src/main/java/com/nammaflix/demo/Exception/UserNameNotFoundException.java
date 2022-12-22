package com.nammaflix.demo.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNameNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4267989204065212524L;

	public UserNameNotFoundException(String message) {
		super(message);
	}
}
