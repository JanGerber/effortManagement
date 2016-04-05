package com.effortmanagement.model;


public class CreateSemester {
	

	private String semesterName;
	private String  startDatum;
	private String endDatum;
	private int user_Id;
	
	/**
	 * @param semesterId
	 * @param semesterName
	 * @param startDatum
	 * @param endDatum
	 * @param user_Id
	 */
	public CreateSemester(int semesterId, String semesterName, String startDatum, String endDatum, int user_Id) {
		this.semesterName = semesterName;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
		this.user_Id = user_Id;
	}
	
	public CreateSemester(){
		
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public String getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(String startDatum) {
		this.startDatum = startDatum;
	}
	public String getEndDatum() {
		return endDatum;
	}
	public void setEndDatum(String endDatum) {
		this.endDatum = endDatum;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	
}	