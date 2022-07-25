package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<String> roomNotFoundException(RoomNotFoundException roomNotFoundException){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(roomNotFoundException.getMessage());	
	}
	
	@ResponseBody
	@ExceptionHandler(RoomAlreadyExistException.class)
	public ResponseEntity<String> roomAlreadyExist(RoomAlreadyExistException roomAlreadyExistException){
		return ResponseEntity.status(HttpStatus.FOUND).body(roomAlreadyExistException.getMessage());	
	
	}
	
	@ResponseBody
@ExceptionHandler(RoomFieldsEmptyException.class)
	public ResponseEntity<String> roomFieldsEmptyException(RoomFieldsEmptyException roomFieldsEmptyException){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(roomFieldsEmptyException.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(RoomCountException.class)
	public ResponseEntity<String>roomCountException(RoomCountException roomCountException){
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(roomCountException.getMessage());
	}
	//***************************************************************************************************************************************************
	//***************************************************************************************************************************************************
	//***************************************************************************************************************************************************

	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException userNotFoundException){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundException.getMessage());	
	}

}





