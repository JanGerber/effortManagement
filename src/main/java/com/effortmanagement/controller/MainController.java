package com.effortmanagement.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;

import com.effortmanagement.model.User;
import com.effortmanagement.service.*;



 

 
@Controller
public class MainController {
	
	UserService userService = new UserService();
	
    @RequestMapping("/index")  
    public ModelAndView index(HttpServletRequest request,HttpServletResponse res) {  
    		
             //Startseite
    	System.out.println("Index");
            return new ModelAndView("index");  
    

    }
 
	@RequestMapping("/login")  
    public ModelAndView login(HttpServletRequest request,HttpServletResponse res) {  
		User user = new User();
		user.setUserName(request.getParameter("usrname"));  
		user.setPasswort(request.getParameter("psw"));
        
     
        request.getSession().setAttribute("user", user);
        
        String passwort = userService.getPasswort(user.getUserName());

        if(passwort != null & user.getPasswort().equals(passwort)){  
            user.setUserID(userService.getId(user.getUserName())); 
        	user.setHochschule(userService.getHochschule(user.getUserName()));
        	user.seteMail(userService.getEmail(user.getUserName()));
        	return new ModelAndView("startseite");  
        }  
        else{ 
        	
            return new ModelAndView("index", "falschesPass",true);  
        }
	}

    @RequestMapping("/logout")  
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse res) {  
    		
             //Session löschen
    		request.getSession().removeAttribute("user");
            
            return new ModelAndView("index", "logoutMessage",true);  
    

    }  
    @RequestMapping("/registrieren")  
    public ModelAndView registrieren(HttpServletRequest request,HttpServletResponse res) { 
    	
            String name=request.getParameter("username");  
            String password =request.getParameter("password");
            String passwordWieder =request.getParameter("passwordRepeat");
            String email =request.getParameter("email");
            String university =request.getParameter("university");
            
            User user = new User(name, password, email, university);
            
            if(/*Datenbank überprüfen ob Nutzer vorhanden ist = null*/false){
            	return new ModelAndView("index","userVorhanden", true );
            }
            if(password.equals(passwordWieder)== false){
            	return new ModelAndView("index","passwortUngleich", true );
            }
            
            //User in der Datenbank anlegen
            
            ModelAndView modelAndView = new ModelAndView("startseite");
            modelAndView.addObject("user", user);
                   
            return modelAndView;
    
    }  
}