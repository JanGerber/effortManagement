package com.effortmanagement.model;

public class ChangeUser {
	
	private String userName;
	private String eMail;
	private String hochschule;
	
	
	public ChangeUser() {
	}
	/**
	 * @param userName
	 * @param passwort
	 * @param hochschule
	 */
	public ChangeUser(String userName, String email, String hochschule) {
		this.userName = userName;
		this.hochschule = hochschule;
		this.eMail = email;
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
		return eMail;
	}
	public void setEmail(String email) {
		this.eMail = email;
	}



}