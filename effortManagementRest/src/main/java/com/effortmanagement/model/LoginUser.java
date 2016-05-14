package com.effortmanagement.model;

public class LoginUser {
	private String userName;
	private String passwort;
	
	public LoginUser(){
		
	}
	
	public LoginUser(String username, String passwort_){
		this.userName = username;
		this.passwort = passwort_;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
}
