package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String username;
	private int userid;
	private String password;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	public User(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/*
	 * public User() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * @Override public String toString() { return "Users [userid=" + userid +
	 * ", password=" + password + "]"; } public User(int userid, String password) {
	 * super(); this.userid = userid; this.password = password; } public int
	 * getUserid() { return userid; } public void setUserid(int userid) {
	 * this.userid = userid; } public String getPassword() { return password; }
	 * public void setPassword(String password) { this.password = password; }
	 */
	
	

}
