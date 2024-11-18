package com.m0d.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyAnalyticsAspect {
    @Before("com.m0d.pointcutdeclaration.aspect.AopExpressions.forDaoPackageNoGettersSetters()")
    public void performApiAnalytics(){
        System.out.println("This should be executed before any method for analytics at the Dao package.");
        System.out.println("Except Getters & Setters");
    }
}
