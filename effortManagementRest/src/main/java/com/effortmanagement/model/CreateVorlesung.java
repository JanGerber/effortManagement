package com.effortmanagement.model;
public class CreateVorlesung {

	private int userId;
	private String vorlesungName;
	private int aufwand;
	private int geplanterAufwand;
	private double angestrebteNote; 
	private int creditPoints;
	private int semesterId;
	
	public CreateVorlesung(){
	}
	
	public CreateVorlesung(int userid, String vorlesungsname, int aufwand_, int geplanteraufwand, double angestrebtenote, int creditpoints, int semesterid){
		this.userId = userid;
		this.vorlesungName = vorlesungsname;
		this.aufwand = aufwand_;
		this.geplanterAufwand = geplanteraufwand;
		this.angestrebteNote = angestrebtenote;
		this.creditPoints = creditpoints;
		this.semesterId = semesterid;
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