package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Room;

public interface RoomDao extends JpaRepository<Room, Long> {

	@Query(value = "select r from Room r where r.roomType=?1")
	public List<Room> FindByRoomType(String roomType);

	public List<Room> findAllById(String parseLong);

}
