package com.m0d.springbootrestcrud.rest;

import com.m0d.springbootrestcrud.error.StudentErrorResponse;
import com.m0d.springbootrestcrud.exception.StudentInvalidDataException;
import com.m0d.springbootrestcrud.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentRestControllerHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handelException(StudentNotFoundException exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // This is the Http.status code that will be sent to the browser --> At the network tap
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handelException(StudentInvalidDataException exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // This is the Http.status code that will be sent to the browser --> At the network tap
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handelException(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // This is the Http.status code that will be sent to the browser --> At the network tap
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
