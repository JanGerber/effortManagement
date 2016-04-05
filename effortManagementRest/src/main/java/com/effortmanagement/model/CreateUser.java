package com.effortmanagement.model;

public class CreateUser {
	
	private String userName;
	private String  passwort;
	private String email;
	private String hochschule;
	
	
	public CreateUser() {
	}
	/**
	 * @param userName
	 * @param passwort
	 * @param eMail
	 * @param hochschule
	 */
	public CreateUser(String userName, String passwort, String eMail, String hochschule) {
		this.userName = userName;
		this.passwort = passwort;
		this.hochschule = hochschule;
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
		return email;
	}
	public void setEmail(String eMail) {
		this.email = eMail;
	}



}