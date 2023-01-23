package com.example.hw2.exception;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public GlobalErrorResponse customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomException exception = (CustomException) e;
        return new GlobalErrorResponse(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public GlobalErrorResponse runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) e;
        return new GlobalErrorResponse(400, exception.getMessage());
    }

}
