package com.Thoybur.fullStackbackEnd.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
//ControllerAdvice is used to handle exceptions across the whole application
public class UserNotFoundAdvise {


    //@ResponseBody is used to return the response in the body of the HTTP response
    @ResponseBody
    //this is the exception handler , is used to handle the exception and return a response
    @ExceptionHandler(UserNotFoundException.class)
    //if the exception is UserNotFoundException.class is found then this method will be executed;
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandleer(UserNotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error ", exception.getMessage());
        return response;
    }
}
