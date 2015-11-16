package com.effortmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.effortmanagement.model.Semester;
import com.effortmanagement.service.SemesterService;

@Controller
@RequestMapping(value="/semester")
public class SemesterController {
	
	/*@Autowired
	private SemesterService semesterService;*/
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addSemesterPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("semester", new Semester());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingSemester(@ModelAttribute Semester semester) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		semesterService.addSemester(semester);
		
		String message = "Semester was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfSemester() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		
		List<Semester> semester = semesterService.getSemester();
		modelAndView.addObject("semester", semester);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editSemesterPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		Semester semester = semesterService.getSemester(id);
		modelAndView.addObject("semester",semester);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingSemester(@ModelAttribute Semester semester, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		//semesterService.updateSemester(semester);
		
		String message = "Semester was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSemester(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		semesterService.deleteSemester(id);
		String message = "Semester was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}