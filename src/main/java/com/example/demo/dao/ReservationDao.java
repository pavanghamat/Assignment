package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
	/*
	 * // @Query("Select Count c from Reservation c where c.res_Status=?1"); public
	 * List<Reservation> findReservations(String res_Status);
	 */

	//public Optional<Reservation> findOne(String password);

}
