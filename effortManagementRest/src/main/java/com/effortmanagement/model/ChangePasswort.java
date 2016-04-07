package com.effortmanagement.model;

public class ChangePasswort {
	
	
	private String oldPasswort;
	private String newPasswort;
	
	public ChangePasswort() {
	}

	/**
	 * @param oldPasswort
	 * @param newPasswort
	 */
	public ChangePasswort(String oldPasswort, String newPasswort) {
		this.oldPasswort = oldPasswort;
		this.newPasswort = newPasswort;
	}

	public String getOldPasswort() {
		return oldPasswort;
	}

	public void setOldPasswort(String oldPasswort) {
		this.oldPasswort = oldPasswort;
	}

	public String getNewPasswort() {
		return newPasswort;
	}

	public void setNewPasswort(String newPasswort) {
		this.newPasswort = newPasswort;
	}
}