package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Room;
import com.example.demo.exception.RoomAlreadyExistException;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.RoomNotFoundException;

public interface RoomService {
public List<Room>getRooms();
public Optional<Room> getRoom(long RoomId);
public Room addRoom(Room Room) throws RoomAlreadyExistException, RoomFieldsEmptyException, Exception,RoomFieldsEmptyException;
//public Room updateRoom(Room room) throws RoomNotFoundException, RoomAlreadyExistException;
public void deleteRoom(long parseLong) throws RoomNotFoundException;
Room updateRoom(Room room) throws RoomAlreadyExistException, RoomNotFoundException, RoomFieldsEmptyException;

}
