package com.hop.studentmanagement.exception;

import com.hop.studentmanagement.dto.ValidationError;
import com.hop.studentmanagement.dto.respone.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity <ErrorResponse> handleStudentNotFound(ResourceNotFoundException e, HttpServletRequest request){

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()

        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateStudentCodeException.class)

    public ResponseEntity<ErrorResponse> handleDuplicateStudentCode(DuplicateStudentCodeException e, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()

        );

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e, HttpServletRequest request){
        List<ValidationError> errors = e.getBindingResult().getFieldErrors().stream().map(
                er ->{
                    String fieldName = ((FieldError) er).getField();
                    String code = er.getCode();
                    String erMessage = er.getDefaultMessage();
                    Object rejectObject = ((FieldError) er).getRejectedValue();

                    return new ValidationError(fieldName,code,erMessage,rejectObject);
                }
        ).collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation failed",
                errors,
                request.getRequestURI()
        );


        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }






}
