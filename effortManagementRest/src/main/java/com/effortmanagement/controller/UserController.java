package com.effortmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public User getUser(@RequestParam("userId") int userId) {
		return userService.getUser(userId);//TODO user
    }
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void changeUser( @RequestBody ChangeUser user, @RequestParam("userId") int userId) {
		logger.info("changeUser: " + user.getEmail());
		
		if(user.getEmail() != null){
			logger.info("Email change: " + user.getEmail());
			userService.changeEmail(userId, user.getEmail()); //TODO user
		}
		if(user.getHochschule() != null){
			userService.changeHochschule(userId, user.getHochschule()); //TODO user
		}
		if(user.getUserName() != null){
			userService.changeUserName(userId, user.getUserName()); //TODO user
		}
        
    }
	@RequestMapping(value = "/passwort", method = RequestMethod.PUT)
	public void changePasswort( @RequestBody ChangePasswort passwort , @RequestParam("userId") int userId) {
		userService.changePasswort(userId, passwort); //TODO user
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestParam("userName") String userName, @RequestParam("passwort") String passwort) {
		User user = userService.getUser(userName);
		if (user == null) {
			logger.error("login Controller: user == null");
		}
		logger.error("login Controller:" + user.getUserId() );
		logger.error("login Controller:" + userService.getPasswort(user.getUserId()));
		user.setPasswort(userService.getPasswort(user.getUserId()));		
		if(userName.equals(user.getUserName()) &&  passwort.equals(user.getPasswort()) ){	
		}else{
			throw new UserNotAuthenticated("Falscher User Name oder Falsches Passwort");
		}
		
		return user;
		
    }
	
	


}
