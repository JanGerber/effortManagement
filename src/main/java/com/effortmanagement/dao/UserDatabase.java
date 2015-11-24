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
			r = stmt.executeQuery("Select passwort from user where userName='"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
		
	}

	public ResultSet getEmail(String userName) {
		try{
			r = stmt.executeQuery("Select email from user where userName='"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}

	public ResultSet getHochschule(String userName) {
		try{
			r = stmt.executeQuery("Select hochschule from user where userName='"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}

	public ResultSet getId(String userName) {
		try{
			r = stmt.executeQuery("Select userID from user where userName='"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}
	
	
	
}