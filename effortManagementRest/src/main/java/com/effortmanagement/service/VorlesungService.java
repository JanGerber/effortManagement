package com.effortmanagement.service;

import java.util.List;

import com.effortmanagement.dao.*;
import com.effortmanagement.model.BucheAufwand;
import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Vorlesung;
import com.effortmanagement.model.VorlesungAufwand;

public class VorlesungService {
	
	private VorlesungDatabase vorlesungDAO = new VorlesungDatabase();

	public void createSemester(CreateVorlesung vorlesung) {
		vorlesungDAO.insertSemester(vorlesung);
		
	}

	public List<NoteVorlesung> getNotenList(int semesterId) {
		return vorlesungDAO.selectNotenVorlesung(semesterId);
	}

	public Vorlesung getVorlesungById(int vorlesungId) {
		return vorlesungDAO.selectVorlesungById(vorlesungId);
	}

	public void addAufwand(BucheAufwand aufwand) {
		Vorlesung vorlesung = getVorlesungById(aufwand.getVorlesungId());
		vorlesungDAO.changeAufwand(aufwand.getZeit() + vorlesung.getLernzeit());
		
	}

	public VorlesungAufwand getAufwandById(int vorlesungId) {
		//TODO Berechnung des Nutzten Aufwand Faktors
		Vorlesung vorlesung = getVorlesungById(vorlesungId);
		return null;
	}

	public List<Vorlesung> getVorlesungList(int semesterId) {
		return vorlesungDAO.selectVorlesungListById(semesterId);
	}
}
