package com.effortmanagement.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class PasswordsIsWrongException extends RuntimeException {
	
	private static final long serialVersionUID = -7872762138103237L;
	
	public PasswordsIsWrongException() {
        super();
    }
    public PasswordsIsWrongException(String message, Throwable cause) {
        super(message, cause);
    }
    public PasswordsIsWrongException(String message) {
        super(message);
    }
    public PasswordsIsWrongException(Throwable cause) {
        super(cause);
    }
}
