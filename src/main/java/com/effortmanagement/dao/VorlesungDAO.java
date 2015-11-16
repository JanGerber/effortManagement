package com.effortmanagement.dao;

import java.util.List;

import com.effortmanagement.model.Semester;

public interface VorlesungDAO {
	
	public void addSemester(Semester semester);
	public void updateSemester(Semester semester);
	public Semester getSemester(int id);
	public void deleteSemester(int id);
	public List<Semester> getSemester();

}
