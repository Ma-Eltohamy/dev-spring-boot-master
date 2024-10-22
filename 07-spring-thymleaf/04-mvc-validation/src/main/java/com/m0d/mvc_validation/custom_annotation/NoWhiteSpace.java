package com.m0d.mvc_validation.custom_annotation;

import com.m0d.mvc_validation.validator.TrimValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Constraint(validatedBy = TrimValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWhiteSpace {
    String message() default "Input must not be empty or contain only whitespace";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
