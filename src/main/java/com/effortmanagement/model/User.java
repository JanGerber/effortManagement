package com.effortmanagement.model;

public class User {
	
	private int	userId;
	private String userName;
	private String  passwort;
	private String eMail;
	private String hochschule;
	
	private boolean	loginFail = false;
	private boolean	registerFail = false;
	
	public User() {
		this.userName = "Std Name";
		this.passwort = "STD password";
		this.eMail = "std@test.de";
		this.hochschule = "STD DHBW";
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
		this.eMail = eMail;
		this.hochschule = hochschule;
	}
	public User(String userName, String passwort) {
		this.userName = userName;
		this.passwort = passwort;
		//Datenbank aufrufen und herausfinden wie die email und hochschulen Name sind
		this.eMail = null;
		this.hochschule = null;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserID(int userId) {
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
	public boolean getLoginFail() {
		return loginFail;
	}
	public void setLoginFail(boolean loginFail) {
		this.loginFail = loginFail;
	}
	public boolean getRegisterFail() {
		return registerFail;
	}
	public void setRegisterFail(boolean registerFail) {
		this.registerFail = registerFail;
	}
	


}