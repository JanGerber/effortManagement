package com.effortmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.model.CreateUser;
import com.effortmanagement.model.User;
import com.effortmanagement.service.UserService;

@RestController
@RequestMapping("/")
public class RegistrierenController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void newSemester(@RequestBody CreateUser user) {
		
		userService.newUser(user);
		//TODO log the user in
		
    }
	
}
