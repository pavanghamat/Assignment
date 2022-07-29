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
import com.example.demo.service.ReservationService;

import com.example.demo.entity.Reservation;
import com.example.demo.exception.ReservationAlreadyExistException;
import com.example.demo.exception.ReservationFieldEmptyException;
import com.example.demo.exception.ReservationNotFoundException;

@RestController
@RequestMapping("/ReservationController")
public class ReservationController {
	Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@GetMapping("/message")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		return "open console to check log message";
	}
	

	@Autowired
	private ReservationService ReservationService;

	@GetMapping("/Reservations")
	public ResponseEntity<List<Reservation>> getReservations() {
		logger.info("Request fo all Reservations");

		return ResponseEntity.status(HttpStatus.OK).body(this.ReservationService.getReservations());
	}

	@GetMapping("/Reservations/{ReservationsId}")
	public ResponseEntity<Optional<Reservation>> getReservation(@PathVariable String ReservationId) throws ReservationNotFoundException {

		logger.info("Request for one Reservation");
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.ReservationService.getReservation(Long.parseLong(ReservationId)));
	}

	@PostMapping("/addReservations")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation Reservation) throws ReservationAlreadyExistException, ReservationFieldEmptyException, ReservationNotFoundException {
		logger.info("Request to add New Reservation");
		return ResponseEntity.status(HttpStatus.OK).body(this.ReservationService.addReservation(Reservation));
	}

	@PutMapping("/updateReservations")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation Reservation) throws ReservationAlreadyExistException, ReservationFieldEmptyException, ReservationNotFoundException {
		 logger.info("request to Update Reservation");
		return ResponseEntity.status(HttpStatus.OK).body(this.ReservationService.updateReservation(Reservation));
	}

	@DeleteMapping("/Reservations/{ReservationId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable String ReservationId) throws ReservationNotFoundException {
		logger.info("requet to Delete Reservation");
		this.ReservationService.deleteReservation(Long.parseLong(ReservationId));
		return new ResponseEntity<>(HttpStatus.OK);

	}

}