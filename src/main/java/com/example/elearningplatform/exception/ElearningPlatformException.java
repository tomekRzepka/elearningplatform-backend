package com.example.elearningplatform.exception;

public class ElearningPlatformException extends RuntimeException {

    public ElearningPlatformException(String message, Exception e) {
        super(message, e);
    }

    public ElearningPlatformException(String message) {
        super(message);
    }
}
