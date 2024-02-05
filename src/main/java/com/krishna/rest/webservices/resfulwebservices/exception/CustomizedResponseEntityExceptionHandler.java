package com.krishna.rest.webservices.resfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request)
	{
		
		ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex,WebRequest request)
	{
		
		ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(errordetails,HttpStatus.NOT_FOUND);
	}
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(errordetails,HttpStatus.BAD_REQUEST);

	}

	
	
}
