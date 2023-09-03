package com.eng.GRH.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eng.GRH.exception.EmployeeErrorResponse;
import com.eng.GRH.exception.ResourceNotFoundException;

@ControllerAdvice
public class EmployeeHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlleException(ResourceNotFoundException exc) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);

    }

}
