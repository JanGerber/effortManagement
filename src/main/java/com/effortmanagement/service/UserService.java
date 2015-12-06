package com.effortmanagement.service;

import java.sql.*;

import com.effortmanagement.dao.UserDatabase;


public class UserService  {
	private ResultSet r;
	
	
	public boolean userExist(String userName){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
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
			userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
			return false;
		}
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return true;		
		
	}
	
	public String getPasswort(String userName){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
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
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return passwort;
		
	}

	public String getHochschule(String userName){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
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
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return hochschule;
		
	}
	public String getEmail(String userName){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen 
		
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
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return email;
		
	}
	public int getId(String userName){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
		
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
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return userId;
		
	}
	
	public void newUser(String name, String password, String email, String university){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
		
		userDatabase.newUser(name, password, email, university);
		
	}
	
	

	public boolean changePasswort(String userName,String newPasswort){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
	    
		if(userDatabase.changePasswort(getId(userName), newPasswort)){
			userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
			return true;
		}
		
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return false;
		
	}
	public boolean changeEmail(String userName,String newEmail){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
	    
		if(userDatabase.changeEmail(getId(userName), newEmail)){
			userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
			return true;
		}
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return false;
		
	}
	public int changeUserName(String userName,String newUserName){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
		
	    if(!userExist(newUserName)){
		if(userDatabase.changeUserName(getId(userName), newUserName)){
			userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
			return getId(newUserName);
		}
	    }
	    userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return 0;
		
	}
	public boolean changeHochschule(String userName,String newHochschule){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
		
		if(userDatabase.changeHochschule(getId(userName), newHochschule)){
			userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
			return true;
		}
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return false;
		
	}
	
	public String getUserName(int userID){
		UserDatabase userDatabase = new UserDatabase();  //Datenbakverbindung aufbauen
		
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
		userDatabase.disConnectDB(); //Datenbankverbindung schlieﬂen
		return userName;
		
	}
}
