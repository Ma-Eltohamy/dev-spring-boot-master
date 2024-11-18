package com.m0d.pointcutdeclaration.dao;

import com.m0d.pointcutdeclaration.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, Boolean isVIP) {
        System.out.println("\nDoing the adding account processes.");
    }

    private void printCurrentMethod(){
        System.out.print("Calling...   ");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        System.out.println(getClass().getName() + ". ---> " + methodName);
    }

    @Override
    public String getName() {
        printCurrentMethod();
        return name;
    }

    @Override
    public void setName(String name) {
        printCurrentMethod();
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        printCurrentMethod();
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        printCurrentMethod();
        this.serviceCode = serviceCode;
    }
}
