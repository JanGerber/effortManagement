package com.effortmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.model.CreateSemester;
import com.effortmanagement.model.Semester;
import com.effortmanagement.service.SemesterService;

@RestController
@RequestMapping("/semester")
public class SemesterController {
	
	@Autowired
	private SemesterService semesterService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET , produces="application/json")
	public List<Semester> getSemesterList() {
		semesterService.getSemesterList(1); //TODO user
		return null;
    }
	
	@RequestMapping(value = "/{semesterId}", method = RequestMethod.GET, produces="application/json")
	public Semester getSemester(@PathVariable int semesterId) {
		Semester semester = semesterService.getSemester(semesterId);
		if(semester.getUser_Id() != 0){
			//TODO User is not allowed to get this semester
		}
		return semester;
        
    }
	
	
	@RequestMapping(value = "/{semesterId}", method = RequestMethod.DELETE , produces="application/json")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteSemester(@PathVariable int semesterId) {
		Semester semester = semesterService.getSemester(semesterId);
		if(semester.getUser_Id() != 0){
			//TODO User is not allowed to delete this semester
		}
		semesterService.deleteSemester(semesterId);
    }
	
	
	@RequestMapping(value = "/{semesterId}", method = RequestMethod.PUT, produces="application/json")
	public void changeSemester(@PathVariable int semesterId, @RequestBody Semester semester) {
		Semester semesterOld = semesterService.getSemester(semesterId);
		
		if(semesterOld.getUser_Id() != 0){
			//TODO User is not allowed to change this semester
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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void newSemester(@RequestBody CreateSemester semester) {
		semester.setUser_Id(1); //TODO  userId
		semesterService.newSemester(semester); 
    }
	
	
	
}
