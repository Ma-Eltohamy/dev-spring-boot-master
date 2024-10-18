package com.m0d.employee_crud_app_spring_data_jpa.exception;

public class EmployeeInvalidDataException extends RuntimeException {
    public EmployeeInvalidDataException(String message) {
        super(message);
    }
}
