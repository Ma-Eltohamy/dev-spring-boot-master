package com.m0d.pointcutdeclaration.aspect;

import com.m0d.pointcutdeclaration.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class MyLoggingAspect {
    @Before("com.m0d.pointcutdeclaration.aspect.AopExpressions.forDaoPackageNoGettersSetters()")
    public void beforeDaoPackageNoGettersSetters(JoinPoint joinPoint){
        System.out.println("This should be executed before any method at the Dao package.");
        System.out.println("Except Getters & Setters");

        // display the method signature

        System.out.println("============-----------=============");
        System.out.println(joinPoint.getSignature());
        System.out.println("============-----------=============");
        for(Object tmpArg: joinPoint.getArgs()){
            if(tmpArg instanceof Account){
                // first make the down cast
                Account tmpAccount = (Account) tmpArg;

                System.out.println(tmpAccount.getFullName());
                System.out.println(tmpAccount.getServiceCode());
            }
        }
    }


}
