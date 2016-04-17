package com.effortmanagement.service;

import java.util.List;

import com.effortmanagement.dao.*;
import com.effortmanagement.model.BucheAufwand;
import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Vorlesung;

public class VorlesungService {
	
	private VorlesungDatabase vorlesungDatabase = new VorlesungDatabase();

	public void createSemester(CreateVorlesung vorlesung) {
		// TODO Auto-generated method stub
		
	}

	public List<NoteVorlesung> getNotenList(int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vorlesung getVorlesungById(int vorlesungId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAufwand(BucheAufwand aufwand) {
		// TODO Auto-generated method stub
		
	}

	public void getAufwandById(int vorlesungId) {
		// TODO Auto-generated method stub
		
	}

	public List<Vorlesung> getVorlesungList(int semesterId) {
		// TODO Auto-generated method stub
		return null;
	}
}
