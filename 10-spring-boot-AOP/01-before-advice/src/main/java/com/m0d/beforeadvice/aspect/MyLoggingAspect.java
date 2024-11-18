package com.m0d.beforeadvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;


@Aspect
@Component
public class MyLoggingAspect {

    @Pointcut("execution(* com.m0d.beforeadvice.dao.*.add*(..))")
    private void myFirstPointCut(){};

    @Before("myFirstPointCut()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        // Print advice message
        System.out.println("\n=====>>> This is the before advice");

        // Get the method signature
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("Method: " + methodName);

        // Print the class where the advice is applied
        System.out.println("Class: " + getClass().toString());
        System.out.println(getClass().toString());
    }
}
