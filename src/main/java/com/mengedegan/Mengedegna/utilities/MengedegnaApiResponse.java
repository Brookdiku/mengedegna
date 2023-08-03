package com.mengedegan.Mengedegna.utilities;

import org.springframework.http.HttpStatus;

public class MengedegnaApiResponse<T> {
    private T data;
    private String message;



    private HttpStatus status;

    public MengedegnaApiResponse(T data, String message,HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status=status;
    }
    public T getData() {
        return data;
    }
    public String getMessage() {
        return message;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
