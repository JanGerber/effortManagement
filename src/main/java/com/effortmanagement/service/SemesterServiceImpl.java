package com.effortmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.effortmanagement.dao.SemesterDAO;
import com.effortmanagement.model.Semester;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService {
	
	@Autowired
	private SemesterDAO semesterDAO;

	public void addSemester(Semester semester) {
		semesterDAO.addSemester(semester);		
	}

	public void updateSemester(Semester semester) {
		semesterDAO.updateSemester(semester);
	}

	public Semester getSemester(int id) {
		return semesterDAO.getSemester(id);
	}

	public void deleteSemester(int id) {
		semesterDAO.deleteSemester(id);
	}

	public List<Semester> getSemester() {
		return semesterDAO.getSemester();
	}



}
