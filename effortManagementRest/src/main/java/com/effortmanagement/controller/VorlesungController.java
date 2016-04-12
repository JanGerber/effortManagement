package com.effortmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.dao.SemesterDatabase;
import com.effortmanagement.exceptions.UserNotAuthorizedException;
import com.effortmanagement.model.ChangePasswort;
import com.effortmanagement.model.ChangeUser;
import com.effortmanagement.model.User;
import com.effortmanagement.service.UserService;
import com.effortmanagement.service.VorlesungService;

@RestController
@RequestMapping("/vorlesung")
public class VorlesungController {
	
	private VorlesungService vorlesungService = new VorlesungService();
	private final Logger logger = LoggerFactory.getLogger(VorlesungController.class);
	
	
	


}
