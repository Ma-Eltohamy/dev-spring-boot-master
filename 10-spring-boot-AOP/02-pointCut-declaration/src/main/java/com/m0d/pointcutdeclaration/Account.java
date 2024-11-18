package com.m0d.pointcutdeclaration;

public class Account {
    private String fullName;
    private String serviceCode;

    public Account(String fullName, String serviceCode) {
        this.fullName = fullName;
        this.serviceCode = serviceCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
