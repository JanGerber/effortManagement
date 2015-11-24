package com.effortmanagement.service;

import java.sql.*;

import com.effortmanagement.dao.UserDatabase;

public class UserService  {
	private ResultSet r;
	UserDatabase userDatabase = new UserDatabase();
	
	
	
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

	
	
	
}
