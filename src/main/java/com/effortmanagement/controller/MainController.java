package com.effortmanagement.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.effortmanagement.model.User;
import com.effortmanagement.service.SemesterService;
 

 
@Controller
public class MainController {
	
	
 
	@RequestMapping("/login")  
    public ModelAndView login(HttpServletRequest request,HttpServletResponse res) {  
        String name=request.getParameter("usrname");  
        String password=request.getParameter("psw");  
          
        if(password.equals("password")&& name.equals("Mustermann")){  
        String message = "Hallo "+name + " <br> ,Sie haben sich erfolgreich mit diesem Passwort: \" " + password +"\" angeledet";  
        return new ModelAndView("startseite", "message", message);  
        }  
        else{  
            return new ModelAndView("error", "message","Sorry, username or password error");  
        }
	}

    @RequestMapping("/logout")  
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse res) {  
    		
             //Session löschen
    	
            String message = "Sie haben sich erflogreich ausgelogt";
                return new ModelAndView("logout", "message",message);  
    

    }  
    @RequestMapping("/registrieren")  
    public ModelAndView registrieren(HttpServletRequest request,HttpServletResponse res) { 
    	
            String name=request.getParameter("username");  
            String password =request.getParameter("password");
            String passwordWieder =request.getParameter("passwordRepeat");
            String email =request.getParameter("email");
            String university =request.getParameter("university");
           
            /*if(Prüfung ob username schon vorhanden ist){
            	//return Username schon vorhanden
            }
            if(Passwort ungleich){
            	//return Passwort ungleich
            }
            User neuerUser = new User(/*höchste User ID finden und um 1 erhöhen, name, password, email, university);
            
            ModelAndView modelAndView = new ModelAndView("startseite");
            modelAndView.addObject("user", neuerUser);
            */         
            String message = "Sie haben sich mit folgenden Werten regestriert" + "<br>Name: " + name + "<br>Passwort: " + password + "<br>PasswortWieder: "+ passwordWieder +  "<br>email: " + email + "<br>University: " + university;
                return new ModelAndView("registriert", "message",message);  
    

    }  
}