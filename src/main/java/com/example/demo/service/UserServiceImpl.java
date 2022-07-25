package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

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
	public User addUser(User user) {

		UserDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(int UserId) {
	}

	@Override
	public User updateUser(User User) {
		UserDao.save(User);
		return User;
	}

	@Override
	public User getUser(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}
}
