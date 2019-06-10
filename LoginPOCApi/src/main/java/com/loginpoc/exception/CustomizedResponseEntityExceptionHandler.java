package com.loginpoc.exception;

import javax.persistence.PersistenceException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.loginpoc.controller.AuthenticationController;
import com.loginpoc.model.ErrorDetails;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LogManager.getLogger(AuthenticationController.class);

	@ExceptionHandler(LoginPOCException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(LoginPOCException ex, WebRequest request) {
		
	    ErrorDetails errorDetails = new ErrorDetails( ex.getMessage(),
	        request.getDescription(false));
	    
	    logger.debug("CustomizedResponseEntityExceptionHandler >>> handleUserNotFoundException ############ "+ ex.getMessage());
	    
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
	    logger.debug("CustomizedResponseEntityExceptionHandler >>> handleMethodArgumentNotValid ############ "+ ex.getMessage());

		return new ResponseEntity<>(ex.getMessage(), status);
	}
	
	@ExceptionHandler(PersistenceException.class)
	public final ResponseEntity<ErrorDetails> handleAllJPAExceptions(PersistenceException ex, WebRequest request) {
	  
		ErrorDetails errorDetails = new ErrorDetails( ex.getMessage(),
	      request.getDescription(false));
		
	    logger.debug("CustomizedResponseEntityExceptionHandler >>> handleAllJPAExceptions ############ "+ ex.getMessage());
		
	  return new ResponseEntity<>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	  
		ErrorDetails errorDetails = new ErrorDetails( ex.getMessage(),
	      request.getDescription(false));
		
	    logger.debug("CustomizedResponseEntityExceptionHandler >>> handleAllExceptions ############ "+ ex.getMessage());

	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
