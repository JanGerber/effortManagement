package com.effortmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.dao.SemesterDatabase;
import com.effortmanagement.exceptions.UserNotAuthorizedException;
import com.effortmanagement.model.BucheAufwand;
import com.effortmanagement.model.ChangePasswort;
import com.effortmanagement.model.ChangeUser;
import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.EndNote;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Semester;
import com.effortmanagement.model.User;
import com.effortmanagement.model.Vorlesung;
import com.effortmanagement.model.VorlesungAufwand;
import com.effortmanagement.service.SemesterService;
import com.effortmanagement.service.UserService;
import com.effortmanagement.service.VorlesungService;

@RestController
@RequestMapping("/vorlesung")
public class VorlesungController {
	
	private VorlesungService vorlesungService = new VorlesungService();
	private SemesterService semesterService = new SemesterService();
	private final Logger logger = LoggerFactory.getLogger(VorlesungController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createVorlesung(@RequestBody CreateVorlesung vorlesung,  @RequestParam("userId") int userId) {
		vorlesung.setUserId(userId);										//TODO UserId
		vorlesungService.createSemester(vorlesung);
    }
	@RequestMapping(value = "/list/{semesterId}/noten", method = RequestMethod.GET)
	public List<NoteVorlesung> getNotenList(@PathVariable int semesterId,  @RequestParam("userId") int userId) {
		if(semesterService.getSemester(semesterId).getUser_Id() == userId){ //TODO UserId
			throw new UserNotAuthorizedException("Sie können die Noten dieses Semester nicht abrufen!");
		}
		return vorlesungService.getNotenList(semesterId); 
    }
	@RequestMapping(value = "/{vorlesungId}", method = RequestMethod.GET)
	public Vorlesung getVorlesung(@PathVariable int vorlesungId,  @RequestParam("userId") int userId) {
		Vorlesung vorlesung = vorlesungService.getVorlesungById(vorlesungId);
		if(vorlesung.getUserId() != userId){ //TODO UserId
			throw new UserNotAuthorizedException("Sie sind nicht autorisiert sich diese Vorlesung anzeigen zu lassen");
		}
		return vorlesung;
    }
	@RequestMapping(value = "/{vorlesungId}/aufwand", method = RequestMethod.PUT)
	public void bucheAufwand(@RequestBody BucheAufwand aufwand, @PathVariable int vorlesungId, @RequestParam("userId") int userId) {
		if(vorlesungService.getVorlesungById(vorlesungId).getUserId() != userId ){
			throw new UserNotAuthorizedException("Sie sind können auf diese Vorlesung keinen Aufwand buchen");
		}
		vorlesungService.addAufwand(aufwand);
		
    }
	@RequestMapping(value = "/{vorlesungId}/aufwand", method = RequestMethod.GET)
	public VorlesungAufwand getAufwandById(@PathVariable int vorlesungId, @RequestParam("userId") int userId) {
		if(vorlesungService.getVorlesungById(vorlesungId).getUserId() != userId ){ //TODO User Id
			throw new UserNotAuthorizedException("Sie können für diese Vorlesung keine Nutzten/Aufwand betrachten");
		}
		return vorlesungService.getAufwandById(vorlesungId);
    }
	
	@RequestMapping(value = "/list/{semesterId}", method = RequestMethod.GET)
	public List<Vorlesung> getListVorlesung(@PathVariable int semesterId,  @RequestParam("userId") int userId) {
		if(semesterService.getSemester(semesterId).getUser_Id() != userId){ //TODO UserId	
			throw new UserNotAuthorizedException("Sie können die Vorlesungen dieses Semester nicht abrufen!");
		}
		return vorlesungService.getVorlesungList(semesterId); 
    }
	@RequestMapping(value = "/{vorlesungId}/endnote", method = RequestMethod.PUT)
	public void endNoteEintragen(@RequestBody EndNote endNote, @PathVariable int vorlesungId, @RequestParam("userId") int userId) {
		if(vorlesungService.getVorlesungById(vorlesungId).getUserId() != userId ){
			throw new UserNotAuthorizedException("Sie sind können für diese Vorlesung keine Endnote eintragen");
		}
		vorlesungService.changeEndnote(endNote);
		
    }



}
