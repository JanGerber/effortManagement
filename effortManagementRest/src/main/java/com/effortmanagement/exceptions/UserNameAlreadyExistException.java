package com.effortmanagement.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class UserNameAlreadyExistException extends RuntimeException {
	
	private static final long serialVersionUID = -7872762138103237L;
	
	public UserNameAlreadyExistException() {
        super();
    }
    public UserNameAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserNameAlreadyExistException(String message) {
        super(message);
    }
    public UserNameAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
