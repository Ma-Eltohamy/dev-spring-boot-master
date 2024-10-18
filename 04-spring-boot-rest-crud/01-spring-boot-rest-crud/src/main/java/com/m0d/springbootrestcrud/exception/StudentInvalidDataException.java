package com.m0d.springbootrestcrud.exception;

public class StudentInvalidDataException extends RuntimeException{
    public StudentInvalidDataException(String message) {
        super(message);
    }

    public StudentInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentInvalidDataException(Throwable cause) {
        super(cause);
    }
}
