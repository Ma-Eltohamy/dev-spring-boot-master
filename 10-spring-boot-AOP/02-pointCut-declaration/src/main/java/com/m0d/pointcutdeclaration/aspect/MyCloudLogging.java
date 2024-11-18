package com.m0d.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyCloudLogging {
    @Before("com.m0d.pointcutdeclaration.aspect.AopExpressions.forDaoPackageNoGettersSetters()")
    public void logToCloud(){
        System.out.println("This should be executed before any method for the cloud.");
        System.out.println("Except Getters & Setters");
    }
}
