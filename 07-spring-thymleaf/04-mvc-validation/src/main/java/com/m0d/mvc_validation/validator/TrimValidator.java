package com.m0d.mvc_validation.validator;

import com.m0d.mvc_validation.custom_annotation.NoWhiteSpace;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimValidator implements ConstraintValidator<NoWhiteSpace, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Optional: Return false if you want to reject null values
        }
        return value.trim().length() > 0;
    }
}
