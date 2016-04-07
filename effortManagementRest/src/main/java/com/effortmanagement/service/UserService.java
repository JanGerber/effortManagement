package com.effortmanagement.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.effortmanagement.dao.UserDatabase;
import com.effortmanagement.model.ChangePasswort;
import com.effortmanagement.model.CreateUser;
import com.effortmanagement.model.User;


public class UserService  {
	
	private UserDatabase userDatabase = new UserDatabase();
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	public User getUser(String userName){
		User user = userDatabase.getUserByName(userName);	
		return user;
	}
	public User getUser(int userId){
		User user = userDatabase.getUserById(userId);	
		return user;
	}
	

	public void changePasswort(int userId ,ChangePasswort  passwort){
		if(passwort.getOldPasswort().equals(userDatabase.getPasswort(userId))){
		userDatabase.changePasswort(userId, passwort.getNewPasswort()); 
		}else{
			logger.error("altest Passwort falsch(eingegeben, muss): " + passwort.getOldPasswort() + " , " + userDatabase.getPasswort(userId));
			//TODO wrong old password
		}
		
	}
	public void changeEmail(int userId,String newEmail){
		userDatabase.changeEmail(userId, newEmail);
		
	}
	public void changeUserName(int userId,String newUserName){
		if(userDatabase.getUserByName(newUserName) != null){
			//TODO Error userName bereits vergeben
		}
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
