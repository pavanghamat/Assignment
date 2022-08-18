package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	private long id;
	//@NotEmpty
	private long room_num;
	//@NotEmpty
	private String roomType;
	//@NotEmpty
	private double rate;
	//@NotEmpty
	private String status;

	public Room(long id, long room_num, String roomType, double d, String status) {
		super();
		this.id = id;
		this.room_num = room_num;
		this.roomType = roomType;
		this.rate = d;
		this.status = status;
	
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoom_num() {
		return room_num;
	}

	public void setRoom_num(long room_num) {
		this.room_num = room_num;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", room_num=" + room_num + ", roomType=" + roomType + ", rate=" + rate + ", status="
				+ status + "]";
	}


}

/*
 * public Room() { super(); // TODO Auto-generated constructor stub }
 * 
 * public long getId() { return id; }
 * 
 * public void setId(long id) { this.id = id; }
 * 
 * public long getRoom_num() { return room_num; }
 * 
 * public void setRoom_num(long room_num) { this.room_num = room_num; }
 * 
 * public String getRoom_type() { return roomType; }
 * 
 * public void setRoom_type(String room_type, String roomType) { this.roomType =
 * roomType; }
 * 
 * public double getRate() { return rate; }
 * 
 * public void setRate(double d) { this.rate = d; }
 * 
 * public String getStatus() { return status; }
 * 
 * public void setStatus(String status) { this.status = status; }
 * 
 * @Override public String toString() { return "Room [id=" + id + ", room_num="
 * + room_num + ", room_type=" + roomType + ", rate=" + rate + ", status=" +
 * status + "]"; }
 */

