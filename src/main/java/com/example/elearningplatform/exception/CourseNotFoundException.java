package com.example.elearningplatform.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message, Exception e) {
        super(message, e);
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}
