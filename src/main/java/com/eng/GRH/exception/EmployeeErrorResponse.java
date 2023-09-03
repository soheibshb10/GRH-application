package com.eng.GRH.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
