package com.ai.demo.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AIExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleCustomException(Exception aiException) {
        return  aiException.getMessage();
    }
}
