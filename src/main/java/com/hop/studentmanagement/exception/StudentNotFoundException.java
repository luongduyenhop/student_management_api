package com.hop.studentmanagement.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message){
        super(message);
    }
}
