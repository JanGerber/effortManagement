package com.effortmanagement.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.List;

import com.effortmanagement.model.Semester;
import com.effortmanagement.model.User;
import com.effortmanagement.service.*;

import sun.awt.ModalExclude;



 

 
@Controller
public class MainController {
	
	UserService userService = new UserService();
	SemesterService semesterService = new SemesterService();
	
    @RequestMapping("/index")  
    public ModelAndView index(HttpServletRequest request,HttpServletResponse res) {  
    		
            //Startseite
            return new ModelAndView("index");  
    

    }
    @RequestMapping("/startseite")  
    public ModelAndView startseite(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) {  
    		
            //Startseite wenn User angemeldet ist
    		User user = (User) request.getSession().getAttribute("user");
    		if(user == null){
    			redirectAttributes.addFlashAttribute("nichtEingeloggt",true);
    			return new ModelAndView("redirect:index.html"); //TODO Fehlermeldung nichtEingeloggt
    		}
            return new ModelAndView("startseite");  
    

    }
 
	@RequestMapping("/login")  
    public ModelAndView login(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) {  
		User user = new User();
		user.setUserName(request.getParameter("usrname"));  
		user.setPasswort(request.getParameter("psw"));
        
     
        request.getSession().setAttribute("user", user);
        
        String passwort = userService.getPasswort(user.getUserName());
        user = (User) request.getSession().getAttribute("user");
        
        if(passwort != null & user.getPasswort().equals(passwort)){  
            user.setUserId(userService.getId(user.getUserName())); 
        	user.setHochschule(userService.getHochschule(user.getUserName()));
        	user.setEmail(userService.getEmail(user.getUserName()));
        	return new ModelAndView("redirect:startseite.html");  
        }  
        else{ 
        	redirectAttributes.addFlashAttribute("falschesPass",true);
            return new ModelAndView("redirect:index.html");  
        }
	}

    @RequestMapping("/logout")  
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) {  
    		
             //Session löschen
    		request.getSession().removeAttribute("user");
    		redirectAttributes.addFlashAttribute("logoutMessage",true);
            return new ModelAndView("redirect:index.html");  
    

    } 

    @RequestMapping("/registrieren")  
    public ModelAndView registrieren(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) { 
    	
            String name=request.getParameter("username");  
            String password =request.getParameter("password");
            String passwordWieder =request.getParameter("passwordRepeat");
            String email =request.getParameter("email");
            String university =request.getParameter("university");
            
            User user = new User(name, password, email, university);
            
            if(userService.userExist(user.getUserName())){
            	redirectAttributes.addFlashAttribute("userVorhanden",true);
            	return new ModelAndView("redirect:index.html");
            }
            if(password.equals(passwordWieder)== false){
            	redirectAttributes.addFlashAttribute("passwortUngleich",true);
            	return new ModelAndView("redirect:index.html");
            }
            
            //Daten in die Datenbank schreiben
            userService.newUser(user.getUserName(), user.getPasswort(), user.getEmail(), user.getHochschule());
            user.setUserId(userService.getId(user.getUserName()));
            request.getSession().setAttribute("user", user);  
            return new ModelAndView("redirect:startseite.html");
    
    } 
    @RequestMapping("/passwortAendern")  
    public ModelAndView changePasswort(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) { 
	        
    		String altesPasswort=request.getParameter("altesPasswort");  
	        String newPasswort =request.getParameter("neuesPassword");
	        String passwordWieder =request.getParameter("passwordRepeat");
	    		
    		User user = (User) request.getSession().getAttribute("user");
    		
    		if(user != null){
            if( altesPasswort.equals(userService.getPasswort(user.getUserName())) ) {                
                if(newPasswort.equals(passwordWieder)){
                	userService.changePasswort(user.getUserName(), newPasswort);
                	user.setPasswort(userService.getPasswort(user.getUserName()));
                	redirectAttributes.addFlashAttribute("passwortChange",true);
                	return new ModelAndView("redirect:startseite.html");
                }
                redirectAttributes.addFlashAttribute("passwortUngleich",true);
                return new ModelAndView("redirect:startseite.html");
            }
            redirectAttributes.addFlashAttribute("altesPasswortFalsch",true);
            return new ModelAndView("redirect:startseite.html");
    		}
    		redirectAttributes.addFlashAttribute("error",true);
    		return new ModelAndView("redirect:index.html");
    } 
    
    @RequestMapping("/profilAnpassen")  
    public ModelAndView changeProfil(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) { 
	        
    		String userName=request.getParameter("benutzername");  
	        String email =request.getParameter("email");
	        String hochschule =request.getParameter("hochschule");
	    		
    		User user = (User) request.getSession().getAttribute("user");
    		
   		
    		if(user != null){
                if(!userName.equals(user.getUserName())) {                
                	int userId = userService.changeUserName(user.getUserName(), userName);
                	if(userId == 0){
                		redirectAttributes.addFlashAttribute("userVorhanden",true); //TODO Fehlerausgabe
                		return new ModelAndView("redirect:startseite.html"); 
                	}
                	user.setUserName(userService.getUserName(userId));
                }	
                if(!email.equals(user.getEmail())) {                
	            	userService.changeEmail(user.getUserName(), email);
	            	user.setEmail(userService.getEmail(user.getUserName()));
                }
                if(!hochschule.equals(user.getHochschule())) {                
                	userService.changeHochschule(user.getUserName(), hochschule);
                	user.setHochschule(userService.getHochschule(user.getUserName()));
                }
                redirectAttributes.addFlashAttribute("profilAkt",true);
                return new ModelAndView("redirect:startseite.html");
    		}
    		redirectAttributes.addFlashAttribute("nichtEingeloggt",true);
    		return new ModelAndView("redirect:index.html");
    } 
    @RequestMapping("/semester")  
    public ModelAndView semesterAnzeigen(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) { 
    	User user = (User) request.getSession().getAttribute("user");
        if(user == null){
        	redirectAttributes.addFlashAttribute("nichtEingeloggt",true);
			return new ModelAndView("redirect:index.html");
        }
    	List<Semester> semester = semesterService.getSemester(user.getUserId());
    	request.getSession().setAttribute("listSemester", semester);
    	return new ModelAndView("semester");
    }
    
    
	@RequestMapping(value="/semesterEdit{id}")
	public ModelAndView editSemester(HttpServletRequest request,HttpServletResponse res,final RedirectAttributes redirectAttributes) {
		//TODO Fehlerbehandlung ParseInt
		try{
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));  
        String startDatum = request.getParameter("startDatum");
        String endDatum = request.getParameter("endDatum");
        int user_Id = Integer.parseInt(request.getParameter("user_Id"));
        String semesterName = request.getParameter("semesterName");
        //Aktualisierung der Daten in der Datenbank ( Anpassung des Services mit mehrern Parametern)
        semesterService.editSemester(semesterId,semesterName,startDatum,endDatum,user_Id);
		}catch(Exception e){
			return new ModelAndView("semester", "error", true); //TODO es ist Fehler aufgetreten
		}      
        
		return new ModelAndView("redirect:semester.html");
	}
	
	@RequestMapping(value="/semesterNew")
	public ModelAndView newSemester(HttpServletRequest request,HttpServletResponse res, final RedirectAttributes redirectAttributes) {
		//TODO Fehlerbehandlung ParseInt
		
		String startDatum = request.getParameter("startDatum");
        String endDatum = request.getParameter("endDatum");
        String semesterName = request.getParameter("semesterName");
        
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
        	redirectAttributes.addFlashAttribute("nichtEingeloggt",true);
			return new ModelAndView("redirect:index.html");
        }
        
        semesterService.newSemester(semesterName,startDatum,endDatum,user.getUserId()); //Semester neu anlegen
      
		return new ModelAndView("redirect:semester.html");
	}
	
	@RequestMapping(value="/semesterDelete")
	public ModelAndView deleteSemester(HttpServletRequest request,HttpServletResponse res) {
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		//Datenbank eintrag löschen
		User user = (User) request.getSession().getAttribute("user");
		if(true/*TODO überprüfen ob der User Rechte hat dieses Semester zu löschen*/){
			semesterService.deleteSemester(semesterId);
		}
		return new ModelAndView("redirect:semester.html");
	}
}