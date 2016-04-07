package com.effortmanagement.model;

public class ChangeUser {
	
	private String userName;
	private String email;
	private String hochschule;
	
	
	public ChangeUser() {
	}
	/**
	 * @param userName
	 * @param passwort
	 * @param hochschule
	 */
	public ChangeUser(String userName, String eMail, String hochschule) {
		this.userName = userName;
		this.hochschule = hochschule;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHochschule() {
		return hochschule;
	}
	public void setHochschule(String hochschule) {
		this.hochschule = hochschule;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String eMail) {
		this.email = eMail;
	}



}