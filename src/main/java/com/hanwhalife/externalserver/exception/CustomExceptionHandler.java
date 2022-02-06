package com.hanwhalife.externalserver.exception;

import com.hanwhalife.externalserver.domain.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleBindException(CustomException ex) {
        return new ResponseEntity<>(
                ApiResponse.error(ex.getCode(), ex.getMessage()),
                HttpStatus.OK
        );
    }
}
