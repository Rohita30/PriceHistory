package com.pricehistory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pricehistory.exception.PriceHistoryNotFoundException;

@ControllerAdvice
public class PriceHistoryExceptionController { 
	
	@ExceptionHandler(value = PriceHistoryNotFoundException.class)
	   public ResponseEntity<Object> exception(PriceHistoryNotFoundException exception) {
		   
	      return new ResponseEntity<>("Price History is not found", HttpStatus.NOT_FOUND);
	      
	   }

}
