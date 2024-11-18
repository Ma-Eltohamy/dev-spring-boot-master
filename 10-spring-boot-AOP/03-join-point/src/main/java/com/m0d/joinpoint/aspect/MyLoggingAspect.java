package com.m0d.joinpoint.aspect;

import com.m0d.joinpoint.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {
    @AfterThrowing(pointcut = "execution(public void findAccounts(..))", throwing = "theExc")
    public void afterThrowingException(JoinPoint joinPoint, Exception theExc){
        System.out.println("This is the @AfterThrowing exception aspect working.");
//        System.out.println("And this is the modified version of the exception: " + theExc);
    }

    @After("execution(public * findAccounts(..))")
    public void afterSuccessCallingMethod(){
        System.out.println("This is the @After Advice and the method has been called even if it throws errors.");
    }

//    @AfterReturning(pointcut = "execution(public * findAccounts(..))", returning = "result")
    @AfterReturning(pointcut = "execution(public * findAccounts(..))")
    public void afterReturningFindAccounts(JoinPoint joinPoint){
        System.out.println("This is the @AfterReturning annotation");

        System.out.println("Without any change");
//        System.out.println(result);
//
//        for(Account tmp : result){
//            tmp.setName("ramy");
//            tmp.setLevel("soso");
//        }
//        System.out.println("========================================");
    }
}
