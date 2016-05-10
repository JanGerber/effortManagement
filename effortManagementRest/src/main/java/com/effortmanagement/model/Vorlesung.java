package com.effortmanagement.model;
public class Vorlesung {

	private int vorlesungId;
	private String vorlesungName;
	private int aufwand;
	private int geplanterAufwand;
	private double angestrebteNote;
	private double endNote;
	private double lernzeit;
	private int creditPoints;
	private int semesterId;
	private int userId;
	
	public int getVorlesungId() {
		return vorlesungId;
	}
	public void setVorlesungId(int vorlesungId) {
		this.vorlesungId = vorlesungId;
	}
	public String getVorlesungName() {
		return vorlesungName;
	}
	public void setVorlesungName(String vorlesungName) {
		this.vorlesungName = vorlesungName;
	}
	public int getAufwand() {
		return aufwand;
	}
	public void setAufwand(int aufwand) {
		this.aufwand = aufwand;
	}
	public int getGeplanterAufwand() {
		return geplanterAufwand;
	}
	public void setGeplanterAufwand(int geplanterAufwand) {
		this.geplanterAufwand = geplanterAufwand;
	}
	public double getAngestrebteNote() {
		return angestrebteNote;
	}
	public void setAngestrebteNote(double angestrebteNote) {
		this.angestrebteNote = angestrebteNote;
	}
	public double getEndNote() {
		return endNote;
	}
	public void setEndNote(double endNote) {
		this.endNote = endNote;
	}
	public double getLernzeit() {
		return lernzeit;
	}
	public void setLernzeit(double lernzeit) {
		this.lernzeit = lernzeit;
	}
	public int getCreditPoints() {
		return creditPoints;
	}
	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}
	public int getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	


}