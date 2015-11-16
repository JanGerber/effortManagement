package com.effortmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.effortmanagement.model.Semester;

@Repository
public class SemesterDAOImpl implements SemesterDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSemester(Semester semester) {
		getCurrentSession().save(semester);
	}

	public void updateSemester(Semester semester) {
		Semester semesterToUpdate = getSemester(semester.getId());
		semesterToUpdate.setName(semester.getName());
		semesterToUpdate.setRating(semester.getRating());
		getCurrentSession().update(semesterToUpdate);
		
	}

	public Semester getSemester(int id) {
		Semester semester = (Semester) getCurrentSession().get(Semester.class, id);
		return semester;
	}

	public void deleteSemester(int id) {
		Semester semester = getSemester(id);
		if (semester != null)
			getCurrentSession().delete(semester);
	}

	@SuppressWarnings("unchecked")
	public List<Semester> getSemester() {
		return getCurrentSession().createQuery("from Semester").list();
	}

}
