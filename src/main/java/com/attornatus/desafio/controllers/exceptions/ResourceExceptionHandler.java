package com.attornatus.desafio.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.attornatus.desafio.services.exceptions.DataBaseException;
import com.attornatus.desafio.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException error, HttpServletRequest request){
		String errorMessage = "Ressource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(
				Instant.now(), 
				status.value(), 
				errorMessage, 
				error.getMessage(), 
				request.getRequestURI()
				);
	
		return ResponseEntity.status(status).body(standardError);		
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException error, HttpServletRequest request){
		String errorMessage = "Data Base error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(
				Instant.now(), 
				status.value(), 
				errorMessage, 
				error.getMessage(), 
				request.getRequestURI()
				);
	
		return ResponseEntity.status(status).body(standardError);		
	}
	
}
