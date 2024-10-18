package com.m0d.employeesystem.exception;

public class EmployeeInvalidDataException extends RuntimeException{
    public EmployeeInvalidDataException(String message) {
        super(message);
    }

    public EmployeeInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInvalidDataException(Throwable cause) {
        super(cause);
    }
}
