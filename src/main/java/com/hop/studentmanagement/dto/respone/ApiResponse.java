package com.hop.studentmanagement.dto.respone;

public class ApiResponse<T> {
    private final boolean success;

    private final  String message;

    private final T data;

    private static final String DEFAULT_SUCCESS_MESSAGE = "Success";

    private ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public  static  <T>ApiResponse<T> success(T data){
        return new ApiResponse<>(true,DEFAULT_SUCCESS_MESSAGE,data);
    }
    public  static  <T>ApiResponse<T> success(String message, T data){
        return new ApiResponse<>(true,message,data);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


}
