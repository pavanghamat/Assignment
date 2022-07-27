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
import com.example.demo.service.RoomService;
import com.example.demo.entity.Room;
import com.example.demo.exception.RoomAlreadyExistException;
import com.example.demo.exception.RoomCountException;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.RoomNotFoundException;

@RestController
@RequestMapping("/RoomController") 
public class MyController {
	
	Logger logger =LoggerFactory.getLogger(MyController.class);
	
	@GetMapping("/message")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");

		return "open console to check log message";
	}
	@Autowired
	private RoomService RoomService;


	@GetMapping("/Rooms")
	public ResponseEntity<List<Room>>getRooms() {
		logger.info("Get list of all rooms");

		return ResponseEntity.status(HttpStatus.OK).body(this.RoomService.getRooms());
	}

	@GetMapping("/Rooms/{RoomId}")
	public ResponseEntity<Optional<Room>> getRoom(@PathVariable String RoomId) throws RoomNotFoundException {

		logger.info("Get one room using RoomId");
		return ResponseEntity.status(HttpStatus.OK).body(this.RoomService.getRoom(Long.parseLong(RoomId)));
	}

	@PostMapping("/addRooms")
	public ResponseEntity<Room> addRoom(@RequestBody Room Room) throws Exception,RoomAlreadyExistException,RoomCountException,RoomFieldsEmptyException {
		logger.info("Add New room");
		return ResponseEntity.status(HttpStatus.OK).body(this.RoomService.addRoom(Room));
	}

	@PutMapping("/Rooms")
	public ResponseEntity<Room> updateRoom(@RequestBody Room Room) throws RoomNotFoundException, RoomAlreadyExistException, RoomFieldsEmptyException {

		logger.info("Update room");
		return ResponseEntity.status(HttpStatus.OK).body(this.RoomService.updateRoom(Room));
	}

	@DeleteMapping("/Rooms/{RoomId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable String RoomId)
			throws NumberFormatException, RoomNotFoundException {
		logger.info("Delete Room");
		this.RoomService.deleteRoom(Long.parseLong(RoomId));
		return new ResponseEntity<>(HttpStatus.OK);

	}
	@GetMapping("/home")
	public String home() {
		return "Welcome to Room Services";
	}
	//**************************************************************************************************************************************
	//**************************************************************************************************************************************
	
	

}