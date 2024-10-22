package com.m0d.mvc_validation.validator;

import com.m0d.mvc_validation.custom_annotation.CourseCodeAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<CourseCodeAnnotation, String> {
    private String coursePrefix;
    private String preparedMessage;

    @Override
    public void initialize(CourseCodeAnnotation constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
        preparedMessage = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null)
            return false;

        for(int i = 0;i < coursePrefix.length(); ++i)
            if (value.charAt(i) != coursePrefix.charAt(i))
                return false;

        if(value.length() <= coursePrefix.length())
            return false;

        return true;
    }
}
