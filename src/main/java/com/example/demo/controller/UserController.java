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
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/message")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");

		return "open console to check log message";
	}

	@Autowired
private UserService UserService;

	@GetMapping("/Users")
	public ResponseEntity<List<User>> getUsers() {
		logger.info("Get list of all Users");

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.getUsers());
	}

	@GetMapping("/User/{UserId}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable long UserId) throws UserNotFoundException {
		logger.info("Get user using Id");

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.getUser((UserId)));
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User User)
			throws UserAlreadyExistException, UserFieldsEmptyException, RoomFieldsEmptyException {
		logger.info("New user added");
		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.addUser(User));
	}

	@DeleteMapping("/User/{UserId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable long UserId) throws UserNotFoundException {
		logger.info("Delete user");
		this.UserService.deleteUser(UserId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/User")
	public ResponseEntity<User> updateUser(@RequestBody User User)
			throws UserNotFoundException, UserFieldsEmptyException {
		logger.info("Update User");
		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.updateUser(User));
	}
	@PostMapping("/signinUser")
	public ResponseEntity<?> signinUser(@RequestBody User signinUser) {
		//logger.info("New user added");
		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.signinUser(signinUser));
	}

	
	
}
