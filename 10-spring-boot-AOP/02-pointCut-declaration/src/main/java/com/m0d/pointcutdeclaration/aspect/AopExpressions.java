package com.m0d.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {

    @Pointcut("execution(* com.m0d.pointcutdeclaration.dao.AccountDAOImpl.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.m0d.pointcutdeclaration.dao.AccountDAOImpl.get*(..))")
    public void forDaoPackageGetters(){}

    @Pointcut("execution(* com.m0d.pointcutdeclaration.dao.AccountDAOImpl.set*(..))")
    public void forDaoPackageSetters(){}

    @Pointcut("forDaoPackage() && !(forDaoPackageGetters() || forDaoPackageSetters())")
    public void forDaoPackageNoGettersSetters() {}
}
