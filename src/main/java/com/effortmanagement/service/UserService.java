package com.effortmanagement.service;

import java.util.List;

import com.effortmanagement.model.Semester;

public interface UserService {
	
	public void addSemester(Semester semester);
	public void updateSemester(Semester semester);
	public Semester getSemester(int id);
	public void deleteSemester(int id);
	public List<Semester> getSemester();

}
