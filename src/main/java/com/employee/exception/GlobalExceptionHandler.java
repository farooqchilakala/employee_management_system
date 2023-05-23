package com.employee.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.dto.ErrorDetails;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	   
	@ExceptionHandler(ResourceNotFoundException.class)
	
	    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
}