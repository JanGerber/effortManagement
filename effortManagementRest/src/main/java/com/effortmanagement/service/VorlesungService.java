package com.effortmanagement.service;

import java.util.List;

import org.slf4j.LoggerFactory;

import com.effortmanagement.dao.*;
import com.effortmanagement.model.BucheAufwand;
import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.EndNote;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Vorlesung;
import com.effortmanagement.model.VorlesungAufwand;
import org.slf4j.Logger;

public class VorlesungService {
	
	private final Logger logger = LoggerFactory.getLogger(VorlesungService.class);
	
	private VorlesungDatabase vorlesungDAO = new VorlesungDatabase();

	public void createSemester(CreateVorlesung vorlesung) {
		logger.debug("createVorlesung: " + vorlesung.getVorlesungName());
		vorlesungDAO.insertVorlesung(vorlesung);
		
	}

	public List<NoteVorlesung> getNotenList(int semesterId) {
		return vorlesungDAO.selectNotenVorlesung(semesterId);
	}

	public Vorlesung getVorlesungById(int vorlesungId) {
		return vorlesungDAO.selectVorlesungById(vorlesungId);
	}

	public void addAufwand(BucheAufwand aufwand) {
		Vorlesung vorlesung = getVorlesungById(aufwand.getVorlesungId());
		vorlesungDAO.changeAufwand(aufwand.getVorlesungId(),aufwand.getZeit() + vorlesung.getLernzeit());
		
	}

	public VorlesungAufwand getAufwandById(int vorlesungId) {
		Vorlesung vorlesung = getVorlesungById(vorlesungId);
		VorlesungAufwand aufwand = new VorlesungAufwand();
		
		aufwand.setAufwandNutzen(berechneAufwand(vorlesung));
		aufwand.setAngestrebteNote(vorlesung.getAngestrebteNote());
		aufwand.setAufwand(vorlesung.getAufwand());
		aufwand.setCreditPoints(vorlesung.getCreditPoints());
		aufwand.setEndNote(vorlesung.getEndNote());
		aufwand.setLernzeit(vorlesung.getLernzeit());
		aufwand.setSemesterId(vorlesung.getSemesterId());
		aufwand.setUserId(vorlesung.getUserId());
		aufwand.setVorlesungId(vorlesung.getVorlesungId());
		aufwand.setVorlesungName(vorlesung.getVorlesungName());
		aufwand.setGeplanterAufwand(vorlesung.getGeplanterAufwand());
		
		return aufwand;
	}

	private int berechneAufwand(Vorlesung vorlesung) {
		double notenFaktor = vorlesung.getEndNote() / vorlesung.getAngestrebteNote();
		double aufwandFaktor = vorlesung.getLernzeit() / vorlesung.getGeplanterAufwand();
		double verhaeltnis = notenFaktor * aufwandFaktor;
		
		int returnWert;
		if (verhaeltnis < 0.5) {
			returnWert = 125;
		}else if(verhaeltnis <= 0) {
			returnWert = 0;
		}else{
			returnWert =(int) (1 - (verhaeltnis - 0.5)) *100; 
		}
		
		return returnWert; 
	}

	public List<Vorlesung> getVorlesungList(int semesterId) {
		return vorlesungDAO.selectVorlesungListById(semesterId);
	}

	public void changeEndnote(EndNote endNote) {
		vorlesungDAO.changeEndnote(endNote);
		
	}
}
