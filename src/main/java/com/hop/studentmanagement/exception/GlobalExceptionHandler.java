package com.hop.studentmanagement.exception;

import com.hop.studentmanagement.dto.ValidationError;
import com.hop.studentmanagement.dto.respone.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse buildErrorResponse(
    ErrorCode errorCode,
    HttpServletRequest request,
    String message,
    List<ValidationError> errors
)    {
        return new ErrorResponse(
                LocalDateTime.now(),
                errorCode.getHttpStatus().value(),
                errorCode.name(),
                message,
                request.getRequestURI(),
                errors
        );
    }
    @ExceptionHandler(BusinessException.class)

    public ResponseEntity <ErrorResponse> handleBusinessException(BusinessException e, HttpServletRequest request){
        
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(buildErrorResponse(   
                e.getErrorCode(),
                request,   
                e.getMessage(),
                null
        ));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e, HttpServletRequest request){
        List<ValidationError> errors = e.getBindingResult().getFieldErrors().stream().map(
                er ->{
                    String fieldName = er.getField();
                    String code = er.getCode();
                    String erMessage = er.getDefaultMessage();
                    Object rejectObject =  er.getRejectedValue();

                    return new ValidationError(fieldName,code,erMessage,rejectObject);
                }
        ).toList();


        return  ResponseEntity.status(ErrorCode.VALIDATION_ERROR.getHttpStatus()).body(buildErrorResponse(
                ErrorCode.VALIDATION_ERROR,
                request,
                "Dữ liệu không hợp lệ",
                errors
        ));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request){
        
        return  ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus()).body(buildErrorResponse(
                ErrorCode.INTERNAL_SERVER_ERROR,
                request,
                "Lỗi hệ thống",
                null
        ));
    }





}
