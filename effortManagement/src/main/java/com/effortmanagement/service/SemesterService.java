package com.effortmanagement.service;
import java.sql.*;
import java.util.*;

import com.effortmanagement.dao.SemesterDatabase;
import com.effortmanagement.dao.UserDatabase;
import com.effortmanagement.model.Semester;


public class SemesterService {
	private ResultSet r;
	
	
	public List<Semester> getSemester(int userId){
		SemesterDatabase semesterDatabase = new SemesterDatabase(); //Datenbankverbindung aufbauen
		
	    r = semesterDatabase.getSemester(userId);
	    
	    List<Semester> allSemester = new ArrayList<Semester>();
		try {
			while(r.next()){
			
			int semesterId = r.getInt("semesterId");
			String semesterName = r.getString("semesterName");
			String startDatum = r.getString("startDatum"); 	
			String endDatum = r.getString("endDatum"); 		
			int user_Id = r.getInt("user_Id");
			
			Semester semester = new Semester(semesterId,semesterName,startDatum,endDatum,user_Id);
			
			allSemester.add(semester);			
			}
			
			r.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			semesterDatabase.disConnectDB(); //Datenbankverbindung schlieﬂsen
			return null;
		}
		semesterDatabase.disConnectDB(); //Datenbankverbindung schlieﬂsen
		return allSemester;
	}

	public void editSemester(int semesterId,String semesterName, String startDatum, String endDatum, int user_Id) {
		SemesterDatabase semesterDatabase = new SemesterDatabase(); //Datenbankverbindung aufbauen
		
		semesterDatabase.changeSemesterName(semesterId, semesterName);
		semesterDatabase.changeStartDatum(semesterId, startDatum);
		semesterDatabase.changeEndDatum(semesterId, endDatum);
		
		semesterDatabase.disConnectDB(); //Datenbankverbindung schlieﬂsen
		
	}

	public void newSemester(String semesterName, String startDatum, String endDatum, int user_Id) {
		SemesterDatabase semesterDatabase = new SemesterDatabase(); //Datenbankverbindung aufbauen
		
		semesterDatabase.newSemester(semesterName, startDatum, endDatum, user_Id);
		
		semesterDatabase.disConnectDB(); //Datenbankverbindung schlieﬂsen
		
	}
	public void deleteSemester(int semesterId) {
		SemesterDatabase semesterDatabase = new SemesterDatabase(); //Datenbankverbindung aufbauen
		
		semesterDatabase.deleteSemester(semesterId);
		
		semesterDatabase.disConnectDB(); //Datenbankverbindung schlieﬂsen
		
	}
	





}
