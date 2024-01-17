package com.example.elearningplatform.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message, Exception e) {
        super(message, e);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
