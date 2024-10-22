package com.m0d.mvc_validation.custom_annotation;

import com.m0d.mvc_validation.validator.CourseCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCodeAnnotation {
    String message() default "Invalid Course Code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "M0D";
}
