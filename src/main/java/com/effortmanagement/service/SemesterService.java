package com.effortmanagement.service;
import java.sql.*;
import java.util.*;

import com.effortmanagement.dao.SemesterDatabase;
import com.effortmanagement.dao.UserDatabase;
import com.effortmanagement.model.Semester;
import com.effortmanagement.model.User.*;

public class SemesterService {
	private ResultSet r;
	SemesterDatabase semesterDatabase = new SemesterDatabase();
	
	public List<Semester> getSemester(int userId){
	    r = semesterDatabase.getSemester(userId);
	    
	    List<Semester> allSemester = new ArrayList<Semester>();
		try {
			while(r.next()){
			
			int semesterId = r.getInt("semesterId");
			String semesterName = r.getString("semesterName");
			String startDatum = r.getString("startDatum"); 	//TODO es müssen Jahr Monat und Tag sepaerate eingelsen werden
			String endDatum = r.getString("endDatum"); 		//TODO es müssen Jahr Monat und Tag sepaerate eingelsen werden
			int user_Id = r.getInt("user_Id");
			
			Semester semester = new Semester(semesterId,semesterName,startDatum,endDatum,user_Id);
			
			allSemester.add(semester);			
			}
			
			r.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allSemester;
	}

	public void editSemester(int semesterId,String semesterName, String startDatum, String endDatum, int user_Id) {
		semesterDatabase.changeSemesterName(semesterId, semesterName);
		semesterDatabase.changeStartDatum(semesterId, startDatum);
		semesterDatabase.changeEndDatum(semesterId, endDatum);
		
	}

	public void newSemester(String semesterName, String startDatum, String endDatum, int user_Id) {
		semesterDatabase.newSemester(semesterName, startDatum, endDatum, user_Id);
		
	}
	public void deleteSemester(int semesterId) {
		semesterDatabase.deleteSemester(semesterId);
		
	}
	





}
