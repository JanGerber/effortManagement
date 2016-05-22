package com.effortmanagement.interfaces;

import java.util.List;

import com.effortmanagement.model.CreateSemester;
import com.effortmanagement.model.Semester;

public interface SemesterInterface {
	public List<Semester> getSemesterList(int userId);
	
	public int changeSemesterName(int semesterId, String semesterName);
	public int changeEndDatum(int semesterId, String endDatum);
	public int changeStartDatum(int semesterId, String startDatum);
	
	public int newSemester(CreateSemester semester);
	public int deleteSemester(int semesterId);
	public Semester getSemester(int semesterId);
}
