package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoomDao;
import com.example.demo.entity.Room;
import com.example.demo.exception.RoomAlreadyExistException;
import com.example.demo.exception.RoomCountException;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.RoomNotFoundException;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao RoomDao;

	// List<Room> list;
	public RoomServiceImpl() {

	}

	@Override
	public List<Room> getRooms() {
		return RoomDao.findAll();
	}

	@Override
	public Optional<Room> getRoom(long RoomId) {

		return RoomDao.findById(RoomId);
	}

	@Override
	public Room addRoom(Room room) throws RoomAlreadyExistException, Exception, RoomCountException {
		// RoomDao.save(Room);
		// return Room;
		Optional<Room> roomcheck = RoomDao.findById(room.getId());

		if (roomcheck.isPresent()) {
			throw new RoomAlreadyExistException("Room already exist");
		}

		else {
			if (room.getId() == 0 || room.getRate() == 0 || room.getRoom_num() == 0 || room.getRoomType().equals(null)
					|| room.getStatus().equals(null)) {
				throw new RoomFieldsEmptyException("Input fields are missing");
			} else {

				if (RoomDao.FindByRoomType(room.getRoomType()).stream().count() > 5) {
					throw new RoomCountException("Rooms are greater than 5");

				} else {

					RoomDao.save(room);
					return room;
				}
			}
		}
	}

	@Override
	public Room updateRoom(Room room)
			throws RoomAlreadyExistException, RoomNotFoundException, RoomFieldsEmptyException {
		if (RoomDao.findById(room.getId()).isEmpty()) {
			throw new RoomNotFoundException("Room not found");
		} else {
			if (room.getId() == 0 || room.getRate() == 0 || room.getRoom_num() == 0 || room.getRoomType().equals(null)
					|| room.getStatus().equals(null)) {
				throw new RoomFieldsEmptyException("Input fields are missing");
			}

		}
		RoomDao.save(room);

		return room;

	}

	@Override
	public void deleteRoom(long parseLong) throws RoomNotFoundException {

		if (RoomDao.findById(parseLong).isEmpty()) {
			throw new RoomNotFoundException("Room not found");
		} else {
			RoomDao.deleteById(parseLong);
		}
	}

}
