package com.effortmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.dao.SemesterDatabase;
import com.effortmanagement.exceptions.UserNotAuthenticated;
import com.effortmanagement.exceptions.UserNotAuthorizedException;
import com.effortmanagement.model.ChangePasswort;
import com.effortmanagement.model.ChangeUser;
import com.effortmanagement.model.LoginUser;
import com.effortmanagement.model.User;
import com.effortmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService = new UserService();
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public User getUser() {
		return userService.getUser(1);//TODO user
    }
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void changeUser( @RequestBody ChangeUser user) {
		logger.info("changeUser: " + user.getEmail());
		
		
		if(user.getEmail() != null){
			logger.info("Email change: " + user.getEmail());
			userService.changeEmail(1, user.getEmail()); //TODO user
		}
		if(user.getHochschule() != null){
			userService.changeHochschule(1, user.getHochschule()); //TODO user
		}
		if(user.getUserName() != null){
			userService.changeUserName(1, user.getUserName()); //TODO user
		}
        
    }
	@RequestMapping(value = "/passwort", method = RequestMethod.PUT)
	public void changePasswort( @RequestBody ChangePasswort passwort) {
		userService.changePasswort(1, passwort); //TODO user
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestBody LoginUser user) {
		User userToCheck = userService.getUser(user.getUserName());
		if(user.getUserName().equals(userToCheck.getUserName()) &&  user.getPasswort().equals(userToCheck.getPasswort()) ){	
		}else{
			throw new UserNotAuthenticated("Falsches User Name oder Falsches Passwort");
		}
		
		return userToCheck;
		
    }
	
	


}
