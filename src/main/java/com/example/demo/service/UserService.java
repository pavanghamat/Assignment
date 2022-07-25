package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

  public interface UserService {
	  
	  
	public List<User>getUsers();
	public User addUser(User User);
	public void deleteUser(int userId);
	public User updateUser(User user);
	public User getUser(int UserId);

}
