package com.effortmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.effortmanagement.model.User;
import com.effortmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json")
	public User getUser() {
		return userService.getUser(1);//TODO user
         
    }
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces="application/json")
	public void changeUser( @RequestBody User user) {
		if(user.getEmail() != null){
			userService.changeEmail(1, user.getEmail()); //TODO user
		}
		if(user.getHochschule() != null){
			userService.changeHochschule(1, user.getHochschule()); //TODO user
		}
		if(user.getPasswort() != null){
			userService.changePasswort(1, user.getPasswort(), user.getPasswort()); //TODO user and  old password
		}
		if(user.getUserName() != null){
			userService.changeUserName(1, user.getUserName()); //TODO user
		}
        
    }
	


}
