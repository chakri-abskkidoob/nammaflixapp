package com.nammaflix.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<ErrorDetails> UserNameNotFoundExceptionHandler(
			UserNameNotFoundException ue, WebRequest wr){
		ErrorDetails er = new ErrorDetails(ue.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(PasswordNotMatchedException.class)
	public ResponseEntity<ErrorDetails> PasswordNotMatchedException(
			PasswordNotMatchedException pe, WebRequest wr){
		ErrorDetails er = new ErrorDetails(pe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorDetails> InvalidCredentialsException(
			InvalidCredentialsException ie, WebRequest wr) {
		
		ErrorDetails er = new ErrorDetails(ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(UserAlreadyTakenException.class)
	public ResponseEntity<ErrorDetails> UserAlreadyTakenException(UserAlreadyTakenException uae, WebRequest wr){
		ErrorDetails er = new ErrorDetails(uae.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(MoviesNotFoundException.class)
	public ResponseEntity<ErrorDetails> MoviesNotFoundException(MoviesNotFoundException me, WebRequest wr){
		ErrorDetails er = new ErrorDetails(me.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorDetails>CategoryNotFoundException(CategoryNotFoundException ce, WebRequest wr){
		ErrorDetails er = new ErrorDetails(ce.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(MismatchException.class)
	public ResponseEntity<ErrorDetails>MismatchException(MismatchException me, WebRequest wr){
		ErrorDetails er = new ErrorDetails(me.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LogInException.class)
	public ResponseEntity<ErrorDetails>LogInException(LogInException le, WebRequest wr){
		ErrorDetails er = new ErrorDetails(le.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails>UserNotFoundException(UserNotFoundException ue, WebRequest wr){
		ErrorDetails er = new ErrorDetails(ue.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(er, HttpStatus.BAD_GATEWAY);
	}
}
