package com.hop.studentmanagement.dto.respone;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hop.studentmanagement.dto.ValidationError;

import java.time.LocalDateTime;
import java.util.List;
@JsonPropertyOrder({
        "timeStamp",
        "status",
        "error",
        "message",
        "path",
        "errors"
})
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<ValidationError> errors;

    public ErrorResponse(LocalDateTime timeStamp, int status, String error, String message, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;

    }

    public ErrorResponse(LocalDateTime timeStamp, int status, String error, String message, List<ValidationError> errors, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }



    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
