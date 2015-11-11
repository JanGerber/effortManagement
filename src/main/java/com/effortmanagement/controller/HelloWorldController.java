package com.effortmanagement.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/*
 * author: Crunchify.com
 * 
 */
 
@Controller
public class HelloWorldController {
 
	@RequestMapping("/login")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {  
        String name=request.getParameter("usrname");  
        String password=request.getParameter("psw");  
          
        if(password.equals("admin")&& name.equals("jan")){  
        String message = "Hallo "+name + " ,Sie haben sich erfolgreich mit diesem Passwort: \"" + password +"\"angeledet";  
        return new ModelAndView("startseite", "message", message);  
        }  
        else{  
            return new ModelAndView("error", "message","Sorry, username or password error");  
        }
	}
    @RequestMapping("/registrieren")  
    public ModelAndView registrieren(HttpServletRequest request,HttpServletResponse res) {  
            String name=request.getParameter("username");  
            String password =request.getParameter("password");
            String passwordWieder =request.getParameter("passwordRepeat");
            String email =request.getParameter("email");
            String university =request.getParameter("university");
              
            String message = "Sie haben sich mit folgenden Werten regestriert" + "<br>Name: " + name + "<br>Passwort: " + password + "<br>PasswortWieder: "+ passwordWieder +  "<br>email: " + email + "<br>University: " + university;
                return new ModelAndView("registriert", "message",message);  
    

    }  
}