package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	public Optional<User> findByUsernameAndPassword(String Username, String Password);
}




