package com.effortmanagement.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.effortmanagement.model.CreateUser;
import com.effortmanagement.model.User;

public interface UserInterface {
	
	//only changes of database entries implemented
	//new entries should be added
	public int changeData(int userId, String column, String newData);
	public int newUser(CreateUser user);
	public User getUserByName(String userName);
	public String getPasswort(String userName);
	public User getUserById(int userID);
	public String getPasswort(int userId);
}