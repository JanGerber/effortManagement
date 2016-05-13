package com.effortmanagement.model;

public class User {
	
	private int	userId;
	private String userName;
	private String  passwort;
	private String email;
	private String hochschule;
	
	
	public User() {
	}
	/**
	 * @param userName
	 * @param passwort
	 * @param eMail
	 * @param hochschule
	 */
	public User(String userName, String passwort, String eMail, String hochschule) {
		this.userName = userName;
		this.passwort = passwort;
		this.email = eMail;
		this.hochschule = hochschule;
	}
	public User(String userName, String passwort) {
		this.userName = userName;
		this.passwort = passwort;
		//Datenbank aufrufen und herausfinden wie die email und hochschulen Name sind
		this.email = null;
		this.hochschule = null;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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