package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.RoomDao;
import com.example.demo.entity.Room;
import com.example.demo.exception.RoomAlreadyExistException;
import com.example.demo.exception.RoomCountException;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.RoomNotFoundException;

@Service
public class RoomServiceImpl implements RoomService {
	
Logger logger =LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@GetMapping("/message")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");

		return "open console to check log message";
	}

	@Autowired
	private RoomDao RoomDao;

	public RoomServiceImpl() {

	}

	@Override
	public List<Room> getRooms() {
		logger.info("Response to get list of all rooms");
		return RoomDao.findAll();
	}

	@Override
	public Optional<Room> getRoom(long RoomId) throws RoomNotFoundException {
		if (RoomDao.findById(RoomId).isEmpty()) {
			logger.error("Room not found error");
			throw new RoomNotFoundException("Room not found");}
		else {
			Optional<Room> room = RoomDao.findById(RoomId);
			logger.info("response to get single room{}",room);
			return room;
	}
	}

	@Override
	public Room addRoom(Room room) throws RoomAlreadyExistException, Exception, RoomCountException,RoomFieldsEmptyException {
		Optional<Room> roomcheck = RoomDao.findById(room.getId());

		if (roomcheck.isPresent()) {
			logger.error("Room already exist error");
			throw new RoomAlreadyExistException("Room already exist");
		}

		else {
			if (room.getId() == 0 || room.getRate() == 0 || room.getRoom_num() == 0 || room.getRoomType().equals(null)
					|| room.getStatus().equals(null)) {
				logger.error("Input fields are missing error");
				throw new RoomFieldsEmptyException("Input fields are missing");
			} else {

				if (RoomDao.FindByRoomType(room.getRoomType()).stream().count() > 5) {
					logger.error("Rooms are greater than 5 error");
					throw new RoomCountException("Rooms are greater than 5");

				} else {

					RoomDao.save(room);
					logger.info("response to add room{}",room);
					return room;
				}
			}
		}
	}

	@Override
	public Room updateRoom(Room room)throws RoomAlreadyExistException, RoomNotFoundException, RoomFieldsEmptyException {
		
		if (RoomDao.findById(room.getId()).isEmpty()) {
			logger.error("Room not found error");
			throw new RoomNotFoundException("Room not found");
		} 
		else {
			if (room.getId() == 0 || room.getRate() == 0 || room.getRoom_num() == 0 || room.getRoomType().equals(null)
					|| room.getStatus().equals(null)) {
				logger.error("Input fields are missing error");
				
				throw new RoomFieldsEmptyException("Input fields are missing");
			}

		}
		RoomDao.save(room);
		logger.info("response to update room{}",room);

		return room;

	}

	@Override
	public void deleteRoom(long RoomId) throws RoomNotFoundException {
		if (RoomDao.findById(RoomId).isEmpty()) {
			logger.error("Room not found error");
			throw new RoomNotFoundException("Room not found");
		} 
		else {
			
			Optional<Room> room = RoomDao.findById(RoomId);
			RoomDao.deleteById(RoomId);
			logger.info("response to delete room{}",room);
		}
	}



}
