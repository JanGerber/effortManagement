package com.effortmanagement.service;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.effortmanagement.dao.UserDatabase;
import com.effortmanagement.model.CreateUser;
import com.effortmanagement.model.User;


public class UserService  {
	
	@Autowired
	private UserDatabase userDatabase;
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User getUser(String userName){
		User user = userDatabase.getUserByName(userName);	
		return user;
	}
	public User getUser(int userId){
		User user = userDatabase.getUserById(userId);	
		return user;
	}
	

	public void changePasswort(int userId,String oldPasswort, String newPasswort){
		
		userDatabase.changePasswort(userId, newPasswort);
		
	}
	public void changeEmail(int userId,String newEmail){
		userDatabase.changeEmail(userId, newEmail);
		
	}
	public void changeUserName(int userId,String newUserName){
		userDatabase.changeUserName(userId, newUserName);
		
	}
	public void changeHochschule(int userId,String newHochschule){	
		userDatabase.changeHochschule(userId, newHochschule);
	}
	
	public void newUser(CreateUser user){
		//TODO check if user name already in the database
		userDatabase.newUser(user);
	}
}
