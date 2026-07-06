package com.hop.studentmanagement.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object value) {
        super(resourceName + " không tồn tại với " + fieldName + " = " + value);
    }
}
