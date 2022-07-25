package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.RoomFieldsEmptyException;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDao;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return UserDao.findAll();
	}

	@Override
	public User addUser(User user) throws UserAlreadyExistException, RoomFieldsEmptyException {
		/*
		 * UserDao.save(user); return user;
		 */

		Optional<User> usercheck = UserDao.findById(user.getUserid());

		if (usercheck.isPresent()) {
			throw new UserAlreadyExistException("User already exist");
		}

		else {
			if (user.getUserid() == 0 || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
				throw new RoomFieldsEmptyException("Input fields are missing");
			} else {

				UserDao.save(user);
				return user;
			}
		}
	}

	@Override
	public void deleteUser(long parseLong) throws UserNotFoundException {

		if (UserDao.findById(parseLong).isEmpty()) {
			throw new UserNotFoundException("User is not available");

		} else {
			UserDao.deleteById(parseLong);
		}
	}

	@Override
	public User updateUser(User User) {
		UserDao.save(User);
		return User;
	}

	@Override
	public Optional<User> getUser(long UserId) {

		return UserDao.findById(UserId);
	}

}
