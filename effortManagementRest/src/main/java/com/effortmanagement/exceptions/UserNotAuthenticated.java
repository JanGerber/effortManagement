package com.effortmanagement.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public final class UserNotAuthenticated extends RuntimeException {
	
	private static final long serialVersionUID = -7872762138103237L;
	
	public UserNotAuthenticated() {
        super();
    }
    public UserNotAuthenticated(String message, Throwable cause) {
        super(message, cause);
    }
    public UserNotAuthenticated(String message) {
        super(message);
    }
    public UserNotAuthenticated(Throwable cause) {
        super(cause);
    }
}
