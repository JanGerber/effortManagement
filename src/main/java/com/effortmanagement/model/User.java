package com.effortmanagement.model;

public class User {

	private int userID;
	private String username;
	private String  passwort;
	private String eMail;
	private String hochschule;
	
	
	/**
	 * @param userID
	 * @param username
	 * @param passwort
	 * @param eMail
	 * @param hochschule
	 */
	public User(int userID, String username, String passwort, String eMail, String hochschule) {
		this.userID = userID;
		this.username = username;
		this.passwort = passwort;
		this.eMail = eMail;
		this.hochschule = hochschule;
	}
	
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getHochschule() {
		return hochschule;
	}
	public void setHochschule(String hochschule) {
		this.hochschule = hochschule;
	}
	


}