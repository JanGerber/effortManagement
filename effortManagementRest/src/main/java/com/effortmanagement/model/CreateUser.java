package com.effortmanagement.model;

public class CreateUser {
	
	private String userName;
	private String  passwort;
	private String eMail;
	private String hochschule;
	
	
	public CreateUser() {
	}
	/**
	 * @param userName
	 * @param passwort
	 * @param eMail
	 * @param hochschule
	 */
	public CreateUser(String userName, String passwort, String email, String hochschule) {
		this.userName = userName;
		this.passwort = passwort;
		this.hochschule = hochschule;
		this.eMail = email;
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