package com.effortmanagement.exceptions;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.tags.form.PasswordInputTag;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { UserNotAuthorizedException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{ \"statusCode\":\"403\", \"errorMessage\" : \"" +  ex.getMessage() + "\"}";
        HttpHeaders httpHeader = new HttpHeaders();
        
        return handleExceptionInternal(ex, bodyOfResponse, httpHeader, HttpStatus.FORBIDDEN, request);
    }
    @ExceptionHandler(value = { UserNotAuthenticated.class})
    protected ResponseEntity<Object> handleConflict4(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{ \"statusCode\":\"403\", \"errorMessage\" : \"" +  ex.getMessage() + "\"}";
        HttpHeaders httpHeader = new HttpHeaders();
        
        return handleExceptionInternal(ex, bodyOfResponse, httpHeader, HttpStatus.FORBIDDEN, request);
    }
    @ExceptionHandler(value = { UserNameAlreadyExistException.class , PasswordsIsWrongException.class})
    protected ResponseEntity<Object> handleConflict2(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{ \"statusCode\":\"400\", \"errorMessage\" : \"" +  ex.getMessage() + "\"}";
        HttpHeaders httpHeader = new HttpHeaders();
        
        return handleExceptionInternal(ex, bodyOfResponse, httpHeader, HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler(value = { SQLException.class})
    protected ResponseEntity<Object> handleConflict3(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{ \"statusCode\":\"503\", \"errorMessage\" : \"Die angeforderten Daten konnten nicht geladen werden. Bitten versuchen Sie es erneut.\"}";
        HttpHeaders httpHeader = new HttpHeaders();
        
        return handleExceptionInternal(ex, bodyOfResponse, httpHeader, HttpStatus.SERVICE_UNAVAILABLE, request);
    }
}