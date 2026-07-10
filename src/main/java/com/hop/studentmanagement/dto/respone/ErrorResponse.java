package com.hop.studentmanagement.dto.respone;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hop.studentmanagement.dto.ValidationError;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private LocalDateTime  timestamp;
    private int status;
    private String code;
    private String message;
    private String path;
    private List<ValidationError> errors;

    public ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String code,
        String message,
        String path,
        List<ValidationError> errors
)    {
        this.timestamp = timestamp;
        this.status = status;
        this.code = code;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }



    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public List<ValidationError> getErrors() {
        return errors;
    }
    public String getPath() {
        return path;
    }

}
