package com.effortmanagement.service;

import java.sql.*;

import com.effortmanagement.dao.UserDatabase;


public class UserService  {
	private ResultSet r;
	UserDatabase userDatabase = new UserDatabase();
	
	public boolean userExist(String userName){
	    r = userDatabase.getUser(userName);
	    String user = null; 
	   
		try {
			while(r.next()){
			
			user = r.getString(1);
			}
			r.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user == null){
			return false;
		}
		
		return true;		
		
	}
	
	public String getPasswort(String userName){
	    r = userDatabase.getPasswort(userName);
	    String passwort = null; 
	   
		try {
			while(r.next()){
			
			passwort = r.getString(1);
			}
			r.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return passwort;
		
	}

	public String getHochschule(String userName){
	    r = userDatabase.getHochschule(userName);
	    String hochschule = null; 
	   
		try {
			while(r.next()){
			
			hochschule = r.getString(1);
			}
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hochschule;
		
	}
	public String getEmail(String userName){
	    r = userDatabase.getEmail(userName);
	    String email = null; 
	   
		try {
			while(r.next()){
			
			email = r.getString(1);
			}
		    r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return email;
		
	}
	public int getId(String userName){
	    r = userDatabase.getId(userName);
	    int userId = 0; 
	   
		try {
			while(r.next()){
			
			userId = r.getInt(1);
			}
		    r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userId;
		
	}
	
	public void newUser(String name, String password, String email, String university){
		
		userDatabase.newUser(name, password, email, university);
		
	}
	
	

	public boolean changePasswort(String userName,String newPasswort){
	    
		if(userDatabase.changePasswort(getId(userName), newPasswort)){
		return true;
		}
		return false;
		
	}
	public boolean changeEmail(String userName,String newEmail){
	    
		if(userDatabase.changeEmail(getId(userName), newEmail)){
		return true;
		}
		return false;
		
	}
	public int changeUserName(String userName,String newUserName){
	    if(!userExist(newUserName)){
		if(userDatabase.changeUserName(getId(userName), newUserName)){
		return getId(newUserName);
		}
	    }
		return 0;
		
	}
	public boolean changeHochschule(String userName,String newHochschule){
	    
		if(userDatabase.changeHochschule(getId(userName), newHochschule)){
		return true;
		}
		return false;
		
	}
	
	public String getUserName(int userID){
	    r = userDatabase.getUserName(userID);
	    String userName = null; 
	   
		try {
			while(r.next()){
			
			userName = r.getString(1);
			}
		    r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userName;
		
	}
}
