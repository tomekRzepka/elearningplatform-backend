package com.example.elearningplatform;

public class ElearningPlatformException extends RuntimeException {

    public ElearningPlatformException(String message, Exception e) {
        super(message, e);
    }

    public ElearningPlatformException(String message) {
        super(message);
    }
}
