package com.hanwhalife.externalserver.exception;

import lombok.Getter;

@Getter
public class CustomException extends Exception{
    private final int code;
    private final String message;

    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(String message) {
        this.code = 500; // default
        this.message = message;
    }
}
