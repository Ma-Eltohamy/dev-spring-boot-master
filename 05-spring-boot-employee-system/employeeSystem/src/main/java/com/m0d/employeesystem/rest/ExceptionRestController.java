package com.m0d.employeesystem.rest;

import com.m0d.employeesystem.error_response.EmployeeErrorResponse;
import com.m0d.employeesystem.exception.EmployeeInvalidDataException;
import com.m0d.employeesystem.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handelException(EmployeeNotFoundException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<EmployeeErrorResponse> handelException(EmployeeInvalidDataException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
