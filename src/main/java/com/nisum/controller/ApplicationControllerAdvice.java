package com.nisum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.custom.exceptions.NoUserFoundException;

/**
 * @author Dinesh Dontha
 * 
 * This controller advice the "common" exceptions among
 * the controllers. As of now, this controller advice
 * handles UserController & sampleController exceptions
 * 
 */
@ControllerAdvice(basePackageClasses = {UserController.class, SampleController.class})
public class ApplicationControllerAdvice {

	
	@ExceptionHandler(NoUserFoundException.class)
	@ResponseBody
	public ResponseEntity<String> handleUserNotFound(){
		return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
	}
}
