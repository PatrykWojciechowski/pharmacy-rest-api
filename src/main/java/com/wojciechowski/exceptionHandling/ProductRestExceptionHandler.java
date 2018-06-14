package com.wojciechowski.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductRestExceptionHandler {

	//catching ProductNotFound exception
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException exc){
	
		ProductErrorResponse error = new ProductErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//catching any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(Exception exc){
	
		ProductErrorResponse error = new ProductErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
