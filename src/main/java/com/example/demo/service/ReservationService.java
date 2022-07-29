package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Reservation;
import com.example.demo.exception.ReservationAlreadyExistException;
import com.example.demo.exception.ReservationFieldEmptyException;
import com.example.demo.exception.ReservationNotFoundException;

public interface ReservationService {
	public List<Reservation>getReservations();
	public Optional<Reservation> getReservation(long ReservationId) throws ReservationNotFoundException;
	public Reservation addReservation(Reservation reservation) throws ReservationAlreadyExistException, ReservationFieldEmptyException, ReservationNotFoundException;
	public Reservation updateReservation(Reservation reservation) throws ReservationAlreadyExistException,ReservationFieldEmptyException, ReservationNotFoundException;
	public void deleteReservation(long reservationId) throws ReservationNotFoundException;
	

}
