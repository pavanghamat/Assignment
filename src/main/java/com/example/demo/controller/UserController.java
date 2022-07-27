package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserFieldsEmptyException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/UserController")
public class UserController {
	
	/*
	 * Logger logger1 =LoggerFactory.getLogger(UserController.class);
	 * 
	 * @GetMapping("/message") public String getMessage() {
	 * logger1.info("[getMessage] info message");
	 * logger1.warn("[getMessage] warn message");
	 * logger1.error("[getMessage] error message"); return
	 * "open console to check log message"; }
	 */


	@Autowired
	private UserService UserService;

	@GetMapping("/Users")
	public ResponseEntity<List<User>> getUsers() {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.getUsers());
	}

	@GetMapping("/User/{UserId}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable long UserId) throws UserNotFoundException {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.getUser((UserId)));
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User User) throws UserAlreadyExistException,UserFieldsEmptyException, RoomFieldsEmptyException {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.addUser(User));
	}

	@DeleteMapping("/User/{UserId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable long UserId) throws UserNotFoundException{

		this.UserService.deleteUser(UserId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	
	
	 @PutMapping("/User")
     public ResponseEntity<User> updateUser(@RequestBody User User) throws UserNotFoundException, UserFieldsEmptyException {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.updateUser(User));
	}
}
