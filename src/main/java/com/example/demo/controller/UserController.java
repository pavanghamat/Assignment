package com.example.demo.controller;

import java.util.List;
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
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/UserController")
public class UserController {

	@Autowired
	private UserService UserService;

	@GetMapping("/Users")
	public ResponseEntity<List<User>> getUsers() {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.getUsers());
	}

	@GetMapping("/User/{UserId}")
	public ResponseEntity<User> getUser(@PathVariable int UserId) {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.getUser((UserId)));
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User User) {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.addUser(User));
	}

	@DeleteMapping("/User/{UserId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable int UserId) {

		this.UserService.deleteUser(UserId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	
	
	 @PutMapping("/User")
     public ResponseEntity<User> updateUser(@RequestBody User User) {

		return ResponseEntity.status(HttpStatus.OK).body(this.UserService.updateUser(User));
	}
}
