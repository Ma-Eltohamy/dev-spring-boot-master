package com.m0d.mvc_validation.model;


import com.m0d.mvc_validation.custom_annotation.CourseCodeAnnotation;
import com.m0d.mvc_validation.custom_annotation.NoWhiteSpace;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
//    @NotEmpty(message = "is required")
//    @NoWhiteSpace(message = "First name can't contain only white spaces")
    private String firstName;

    @NotNull(message = "is required")
//    @NotEmpty(message = "is required")
//    @NoWhiteSpace(message = "Last name can't contain only white spaces")
    private String lastName;

    @NotNull(message = "is required")
//    @NotEmpty(message = "is required")
    @NoWhiteSpace(message = "Email can't contain only white spaces")
    @Email(message = "Please enter a valid email")
    private String email;

    @Min(value = 0, message = "it must be more than 0")
    @Max(value = 10, message = "it must be less than or equal to 10")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "It must contains only 5 digits/chars")
    @NotNull(message = "is required")
    private String postalCode;

    @CourseCodeAnnotation(value="LUV", message = "Course code must starts with 'LUV' + 'CourseCode'")
    @NotNull(message = "is required")
    private String courseCode;

    public Customer() {
    }

    public @NotNull(message = "is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "is required") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull(message = "is required") @Email(message = "Please enter a valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "is required") @Email(message = "Please enter a valid email") String email) {
        this.email = email;
    }

    public @Min(value = 0, message = "it must be more than 0") @Max(value = 10, message = "it must be less than or equal to 10") @NotNull(message = "is required") Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(@Min(value = 0, message = "it must be more than 0") @Max(value = 10, message = "it must be less than or equal to 10") @NotNull(message = "is required") Integer freePasses) {
        this.freePasses = freePasses;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "It must contains only 5 digits/chars") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "It must contains only 5 digits/chars") String postalCode) {
        this.postalCode = postalCode;
    }

    public @NotNull(message = "is required") String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(@NotNull(message = "is required") String courseCode) {
        this.courseCode = courseCode;
    }
}
