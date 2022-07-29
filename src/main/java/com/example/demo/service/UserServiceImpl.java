package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserFieldsEmptyException;
import com.example.demo.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

Logger logger =LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@GetMapping("/message")
	public String getMessage() {
		logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");

		return "open console to check log message";
	}
	@Autowired
	private UserDao UserDao;

	@Override
	public List<User> getUsers() {
		logger.info("Response to get list of all Users");
		return UserDao.findAll();
	}

	@Override
	public Optional<User> getUser(long UserId) throws UserNotFoundException {
		if (UserDao.findById(UserId).isEmpty()) {
			logger.error("User not found error");
			throw new UserNotFoundException("User not found");
		} else {
			
			Optional<User> user = UserDao.findById(UserId);
			logger.info("response to get single user{}",user);
			return UserDao.findById(UserId);
		}
	}

	@Override
	public User addUser(User user) throws UserAlreadyExistException, RoomFieldsEmptyException {

		Optional<User> usercheck = UserDao.findById(user.getUserid());

		if (usercheck.isPresent()) {
			logger.error("User already exist error");
			throw new UserAlreadyExistException("User already exist");
		}

		else {
			if (user.getUserid() == 0 || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
				
				logger.error("Input fields are missing error");
				throw new RoomFieldsEmptyException("Input fields are missing");
			} else {

				UserDao.save(user);
				logger.info("response to add user{}",user);
				return user;
			}
		}
	}
	
	@Override
	public User updateUser(User user)
			throws UserNotFoundException, UserFieldsEmptyException {
		if (UserDao.findById(user.getUserid()).isEmpty()) {
			logger.error("User not found error");
			throw new UserNotFoundException("User not found");
		}
		else {
			if (user.getUserid() == 0 || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
				logger.error("nput fields are missing error");
				throw new UserFieldsEmptyException("Input fields are missing");
			}

		}
		UserDao.save(user);
		logger.info("response to update user{}",user);

		return user;

	}

	@Override
	public void deleteUser(long userId) throws UserNotFoundException {

		if (UserDao.findById(userId).isEmpty()) {
			logger.error("User not found error");
			throw new UserNotFoundException("User not found");

		} else {
			Optional<User> user = UserDao.findById(userId);
			UserDao.deleteById(userId);
			logger.info("response to get single deleted user{}",user);
		}
	}
	

}
