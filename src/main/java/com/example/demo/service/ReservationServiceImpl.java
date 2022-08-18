package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.dao.ReservationDao;
import com.example.demo.entity.Reservation;
import com.example.demo.exception.ReservationAlreadyExistException;
import com.example.demo.exception.ReservationFieldEmptyException;
import com.example.demo.exception.ReservationNotFoundException;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao ReservationDao;

	Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	@GetMapping("/message")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");

		return "open console to check log message";
	}

	@Override
	public Reservation addReservation(Reservation reservation)
			throws ReservationAlreadyExistException, ReservationFieldEmptyException {
		Optional<Reservation> reservationcheck = ReservationDao.findById(reservation.getReservationId());

		if (reservationcheck.isPresent()) {
			logger.error("Reservation already exist error");
			throw new ReservationAlreadyExistException("Reservation already exist");
		}

		else {
			if (reservation.getReservationId() == 0 || reservation.getRoomId() == 0 || reservation.getHotelId() == 0
					|| reservation.getNumber_Of_Guest() == 0 || reservation.getName().equals(null)
					|| reservation.getEmail().equals(null) || reservation.getStart_Date().equals(null)
					|| reservation.getEnd_Date().equals(null) || reservation.getRes_Status().equals(null)
					|| reservation.getComment().equals(null)) {
				logger.error("Input fields are missing error");
				throw new ReservationFieldEmptyException("Input fields are missing");
			} else {

				ReservationDao.save(reservation);
				logger.info("response to add Reservation{}", reservation);
				return reservation;
			}
		}
	}

	@Override
	public Reservation updateReservation(Reservation reservation)
			throws ReservationNotFoundException, ReservationFieldEmptyException {
		if (ReservationDao.findById(reservation.getReservationId()).isEmpty()) {
			logger.error("Reservation not found error");
			throw new ReservationNotFoundException("ReservationNotFoundException not found");
		} else {
			if (reservation.getReservationId() == 0 || reservation.getRoomId() == 0 || reservation.getHotelId() == 0
					|| reservation.getNumber_Of_Guest() == 0 || reservation.getName().equals(null)
					|| reservation.getEmail().equals(null) || reservation.getStart_Date().equals(null)
					|| reservation.getEnd_Date().equals(null) || reservation.getRes_Status().equals(null)
					|| reservation.getComment().equals(null)) {
				logger.error("Input fields are missing error");

				throw new ReservationFieldEmptyException("Input fields are missing");
			}

		}
		ReservationDao.save(reservation);
		logger.info("response to update reservation{}", reservation);

		return reservation;

	}

	@Override
	public void deleteReservation(long reservationId) throws ReservationNotFoundException {
		if (ReservationDao.findById(reservationId).isEmpty()) {
			logger.error("reservation not found error");
			throw new ReservationNotFoundException("Resevation not found");

		} else {
			Optional<Reservation> reservation = ReservationDao.findById(reservationId);
			ReservationDao.deleteById(reservationId);
			logger.info("response to get single deleted reservation{}", reservation);
		}
	}

	@Override
	public List<Reservation> getReservations() {

		logger.info("Response to get list of all Reservations");
		return ReservationDao.findAll();
	}

	@Override
	public Optional<Reservation> getReservation(long ReservationId) throws ReservationNotFoundException {
		if (ReservationDao.findById(ReservationId).isEmpty()) {
			logger.error("Room not found error");
			throw new ReservationNotFoundException("Reservation not found");
		} else {
			Optional<Reservation> reservation = ReservationDao.findById(ReservationId);
			logger.info("response to get single Reservation{}", reservation);
			return reservation;
		}
	}

	public Reservation addReservation1(Reservation reservation) {
		List<Reservation> reservations = ReservationDao.findAll();
		reservations.forEach(r -> {
			if (r.getReservationId() == reservation.getReservationId()) {
				logger.error("Reservation already exist error");
				throw new RuntimeException("Reservation already exist");
			} else {
				if (reservation.getReservationId() == 0 || reservation.getRoomId() == 0 || reservation.getHotelId() == 0
						|| reservation.getNumber_Of_Guest() == 0 || reservation.getName().equals(null)
						|| reservation.getEmail().equals(null) || reservation.getStart_Date().equals(null)
						|| reservation.getEnd_Date().equals(null) || reservation.getRes_Status().equals(null)
						|| reservation.getComment().equals(null)) {
					logger.error("Input fields are missing error");
					throw new RuntimeException("Input fields are missing");
				} else {

					ReservationDao.save(reservation);
					logger.info("response to add Reservation{}", reservation);

				}
		
			}
		});
		return reservation;
	}

}
