package com.effortmanagement.model;


public class ChangeSemester {
	

	private String semesterName;
	private String  startDatum;
	private String endDatum;
	
	
	/**
	 * @param semesterId
	 * @param semesterName
	 * @param startDatum
	 * @param endDatum
	 * @param user_Id
	 */
	public ChangeSemester( String semesterName, String startDatum, String endDatum) {
		this.semesterName = semesterName;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
	}
	
	public ChangeSemester(){
		
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

	
}	