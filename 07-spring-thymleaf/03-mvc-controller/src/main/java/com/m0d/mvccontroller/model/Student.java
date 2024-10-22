package com.m0d.mvccontroller.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favLanguage;
    private List<String> favOperatingSystem;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavLanguage() {
        return favLanguage;
    }

    public void setFavLanguage(String favLanguage) {
        this.favLanguage = favLanguage;
    }

    public List<String> getFavOperatingSystem() {
        return favOperatingSystem;
    }

    public void setFavOperatingSystem(List<String> favOperatingSystem) {
        this.favOperatingSystem = favOperatingSystem;
    }
}
