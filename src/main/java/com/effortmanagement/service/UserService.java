package com.effortmanagement.service;

import java.sql.*;

import com.effortmanagement.dao.UserDatabase;

public class UserService  {
	private ResultSet r;
	UserDatabase userDatabase = new UserDatabase();
	
	
	
	public String getPasswort(userName){
	    int counter=0;
	    r = userDatabase.getPasswort(userName);
	    r.next();
	    
		
		
	}

	
	
	
}
