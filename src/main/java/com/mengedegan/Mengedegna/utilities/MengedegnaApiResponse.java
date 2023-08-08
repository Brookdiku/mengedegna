package com.mengedegan.Mengedegna.utilities;

import org.springframework.http.HttpStatus;

public class MengedegnaApiResponse<T> {
    private final T data;
    private final String message;
    private final HttpStatus status;

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
