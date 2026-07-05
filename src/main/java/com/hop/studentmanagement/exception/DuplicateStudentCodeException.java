package com.hop.studentmanagement.exception;

public class DuplicateStudentCodeException extends RuntimeException{
    public DuplicateStudentCodeException(String message) {
        super(message);
    }
}
