package com.java.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	// for specific Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex,WebRequest req){
		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// for all Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception e,WebRequest req){
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> apiExceptionHandler(APIException ae,WebRequest req){
		ErrorDetails error = new ErrorDetails(new Date(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
	}
	// for validation
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), "Validation failed", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
