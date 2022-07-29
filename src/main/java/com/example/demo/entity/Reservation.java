package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Reservation {
	@Id
	private long ReservationId;
	private String name;
	private String email;
	private long roomId;
	private long hotelId;
	@JsonFormat(pattern="yyyy-MM-dd",shape= Shape.STRING)
	private String start_Date;
	@JsonFormat(pattern="yyyy-MM-dd",shape= Shape.STRING)
	private String end_Date;
	private int number_Of_Guest;
	@JsonFormat(pattern="yyyy-MM-dd",shape= Shape.STRING)
	private String res_Date;
	private String res_Status;
	private String comment;
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(long resId, String name, String email, long roomId, long hotelId, String start_Date,
			String end_Date, int number_Of_Guest, String res_Date, String res_Status, String comment, long ReservationId) {
		super();
		this.ReservationId = ReservationId;
		this.name = name;
		this.email = email;
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.number_Of_Guest = number_Of_Guest;
		this.res_Date = res_Date;
		this.res_Status = res_Status;
		this.comment = comment;
	}
	public long getReservationId() {
		return ReservationId;
	}
	public void setResId(long ReservationId) {
		this.ReservationId = ReservationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	public String getStart_Date() {
		return start_Date;
	}
	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}
	public String getEnd_Date() {
		return end_Date;
	}
	public void setEnd_Date(String end_Date) {
		this.end_Date = end_Date;
	}
	public int getNumber_Of_Guest() {
		return number_Of_Guest;
	}
	public void setNumber_Of_Guest(int number_Of_Guest) {
		this.number_Of_Guest = number_Of_Guest;
	}
	public String getRes_Date() {
		return res_Date;
	}
	public void setRes_Date(String res_Date) {
		this.res_Date = res_Date;
	}
	public String getRes_Status() {
		return res_Status;
	}
	public void setRes_Status(String res_Status) {
		this.res_Status = res_Status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Reservation [ReservationId=" + ReservationId + ", name=" + name + ", email=" + email + ", roomId=" + roomId
				+ ", hotelId=" + hotelId + ", start_Date=" + start_Date + ", end_Date=" + end_Date
				+ ", number_Of_Guest=" + number_Of_Guest + ", res_Date=" + res_Date + ", res_Status=" + res_Status
				+ ", comment=" + comment + "]";
	}
	
	
}