package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserFieldsEmptyException;
import com.example.demo.exception.UserNotFoundException;

  public interface UserService {
	  
	  
	public List<User>getUsers();
	public User addUser(User User) throws UserAlreadyExistException, RoomFieldsEmptyException;
	public User updateUser(User user) throws UserNotFoundException, UserFieldsEmptyException;
	public Optional<User> getUser(long userId) throws UserNotFoundException;
	public void deleteUser(long parseLong) throws UserNotFoundException;
	//User getUser(long UserId);

}
