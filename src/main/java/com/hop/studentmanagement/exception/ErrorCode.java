import org.springframework.http.HttpStatus;

public enum ErrorCode{
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND),

    CLASSROOM_NOT_FOUND(HttpStatus.NOT_FOUND),

    DUPLICATE_STUDENT_CODE(HttpStatus.CONFLICT),

    VALIDATION_ERROR(HttpStatus.BAD_REQUEST),
    
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}