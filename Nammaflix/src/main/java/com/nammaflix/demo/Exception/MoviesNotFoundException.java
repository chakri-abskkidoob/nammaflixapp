package com.nammaflix.demo.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoviesNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoviesNotFoundException(String message) {
		super(message);
	}
}
