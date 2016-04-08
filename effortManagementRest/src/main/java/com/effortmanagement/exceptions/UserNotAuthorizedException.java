package com.effortmanagement.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public final class UserNotAuthorizedException extends RuntimeException {
	
	private static final long serialVersionUID = -7872762138103237L;
	
	public UserNotAuthorizedException() {
        super();
    }
    public UserNotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserNotAuthorizedException(String message) {
        super(message);
    }
    public UserNotAuthorizedException(Throwable cause) {
        super(cause);
    }
}
