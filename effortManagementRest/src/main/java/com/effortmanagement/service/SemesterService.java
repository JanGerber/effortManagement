package com.effortmanagement.service;
import java.sql.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.effortmanagement.dao.SemesterDatabase;
import com.effortmanagement.dao.UserDatabase;
import com.effortmanagement.model.CreateSemester;
import com.effortmanagement.model.Semester;


public class SemesterService {
	
	private SemesterDatabase semesterDao = new SemesterDatabase();
	
	private final Logger logger = LoggerFactory.getLogger(SemesterService.class);
	

	
	public List<Semester> getSemesterList(int userId){
		return semesterDao.getSemesterList(userId); 
	}

	public void changeSemesterName(int semesterId,String semesterName) {
		semesterDao.changeSemesterName(semesterId, semesterName);
	}
	public void changeStartDatum(int semesterId, String startDatum) {
		
		semesterDao.changeStartDatum(semesterId, startDatum);
			
		}
	public void changeEndDatum(int semesterId, String endDatum) {
		semesterDao.changeEndDatum(semesterId, endDatum);
	}
	
	public void newSemester(CreateSemester semester) {
		semesterDao.newSemester(semester);
	}
	public Semester getSemester(int semesterId) {
		Semester semester =  semesterDao.getSemester(semesterId);
		return semester;
	}
	public void deleteSemester(int semesterId) {
		semesterDao.deleteSemester(semesterId);
	}




}
