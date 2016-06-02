package com.effortmanagement.interfaces;

import java.util.List;

import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.EndNote;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Vorlesung;

public interface VorlesungInterface {
	public List<Vorlesung> selectVorlesungListById(int semesterId);
	public int changeAufwand(int vorlesungId, double neuerAufwand);
	public Vorlesung selectVorlesungById(int vorlesungId);
	public List<NoteVorlesung> selectNotenVorlesung(int semesterId);
	public int insertVorlesung(CreateVorlesung vorlesung);
	public int changeEndnote(EndNote endNote);
	
}
