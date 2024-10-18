package com.m0d.employee_crud_app_spring_data_jpa.rest;

import com.m0d.employee_crud_app_spring_data_jpa.error.EmployeeErrorResponse;
import com.m0d.employee_crud_app_spring_data_jpa.exception.EmployeeInvalidDataException;
import com.m0d.employee_crud_app_spring_data_jpa.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {
    @ExceptionHandler
    ResponseEntity<EmployeeErrorResponse> employeeNotFoundHandler(EmployeeNotFoundException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<EmployeeErrorResponse> employeeInvalidDataHandler(EmployeeInvalidDataException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<EmployeeErrorResponse> employeeExceptionHandler(Exception exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
