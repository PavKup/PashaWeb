package com.example.PashaWeb.controller;

import com.example.PashaWeb.exception.EntityNotFoundException;
import com.example.PashaWeb.exception.IllegalInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseBody
    @ExceptionHandler({EntityNotFoundException.class, IllegalInputException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}
