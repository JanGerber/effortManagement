package com.effortmanagement.dao;

import com.effortmanagement.dao.*;
import java.sql.*;

public class UserDatabase extends AccesDatabase {
	private ResultSet r;
	public UserDatabase(){
	connectDB();
	}
	
	public ResultSet getPasswort(String userName){
		try{
			r = stmt.executeQuery("Select password from user where" + userName);
			return r;
		}catch(Exception ex){
			return null;
		}
		
	}
	
	
	
}