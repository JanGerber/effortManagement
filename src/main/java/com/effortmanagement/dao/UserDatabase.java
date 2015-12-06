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
			r = stmt.executeQuery("Select passwort from user where userName like '"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
		
	}

	public ResultSet getEmail(String userName) {
		try{
			r = stmt.executeQuery("Select email from user where userName like '"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}

	public ResultSet getHochschule(String userName) {
		try{
			r = stmt.executeQuery("Select hochschule from user where userName like '"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}

	public ResultSet getId(String userName) {
		try{
			r = stmt.executeQuery("Select userID from user where userName like '"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}

	public ResultSet getUser(String userName) {
		try{
			r = stmt.executeQuery("Select userName from user where userName like '"+userName+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}

	public void newUser(String name, String password, String email, String university) {
		
			try {
				stmt.executeUpdate("INSERT INTO user (userName, passwort, email, hochschule) VALUES ('"+name+"', '"+password+"', '"+email+"', '"+university+"');");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		
		
	}

	public boolean changePasswort(int userId, String newPasswort) {
		try {
			stmt.executeUpdate("UPDATE user SET passwort= '"+ newPasswort +"' WHERE userId IN ('" + userId + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean changeEmail(int userId, String newEmail) {
		try {
			stmt.executeUpdate("UPDATE user SET email= '"+ newEmail +"' WHERE userId IN ('" + userId + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean changeHochschule(int userId, String newHochschule) {
		try {
			stmt.executeUpdate("UPDATE user SET hochschule= '"+ newHochschule +"' WHERE userId IN ('" + userId + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean changeUserName(int userId, String newUserName) {
		try {
			stmt.executeUpdate("UPDATE user SET userName= '"+ newUserName +"' WHERE userId IN ('" + userId + "')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet getUserName(int userID) {
		try{
			r = stmt.executeQuery("Select userName from user where userID like '"+userID+"'");
			return r;
		}catch(Exception ex){
			return null;
		}
	}


	
	
}