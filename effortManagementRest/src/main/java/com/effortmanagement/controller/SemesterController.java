package com.effortmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.exceptions.UserNotAuthorizedException;
import com.effortmanagement.model.ChangeSemester;
import com.effortmanagement.model.CreateSemester;
import com.effortmanagement.model.Semester;
import com.effortmanagement.service.SemesterService;

@RestController
@RequestMapping("/semester")
public class SemesterController {
	
	private final Logger logger = LoggerFactory.getLogger(SemesterController.class);
	
	
	
	private SemesterService semesterService = new SemesterService();
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Semester> getSemesterList() {
		return semesterService.getSemesterList(1); //TODO user
    }
	
	@RequestMapping(value = "/{semesterId}", method = RequestMethod.GET)
	public Semester getSemester(@PathVariable int semesterId) {
		Semester semester = semesterService.getSemester(semesterId);
		if(semester.getUser_Id() != 1){
			throw new UserNotAuthorizedException("Sie sind nicht authenfiziert dieses Semester zu betrachten (SemesterId: " + semesterId +")");
		}
		return semester;
        
    }
	
	
	@RequestMapping(value = "/{semesterId}", method = RequestMethod.DELETE , produces="application/json")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteSemester(@PathVariable int semesterId) {
		Semester semester = semesterService.getSemester(semesterId);
		if(semester.getUser_Id() != 1){
			throw new UserNotAuthorizedException("Sie sind nicht authenfiziert dieses Semester zu löschen (SemesterId: " + semesterId +")");
		}
		semesterService.deleteSemester(semesterId);
    }
	
	
	@RequestMapping(value = "/{semesterId}", method = RequestMethod.PUT, produces="application/json")
	public void changeSemester(@PathVariable int semesterId, @RequestBody ChangeSemester semester) {
		Semester semesterOld = semesterService.getSemester(semesterId);
		
		if(semesterOld.getUser_Id() != 1){
			throw new UserNotAuthorizedException("Sie sind nicht authenfiziert dieses Semester zu bearbeiten (SemesterId: " + semesterId +")");
		}
		
		if(semester.getStartDatum() != null){
			semesterService.changeStartDatum(semesterId, semester.getStartDatum());
		}
		if(semester.getEndDatum() != null){
			semesterService.changeEndDatum(semesterId, semester.getEndDatum());		
		}
		if(semester.getSemesterName() != null){
			semesterService.changeSemesterName(semesterId, semester.getSemesterName());
		}
    }
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void newSemester(@RequestBody CreateSemester semester) {
		semester.setUser_Id(1); //TODO  userId
		semesterService.newSemester(semester); 
    }
	
	
	
}
