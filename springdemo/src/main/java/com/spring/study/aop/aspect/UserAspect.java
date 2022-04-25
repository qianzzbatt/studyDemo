package com.spring.study.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author huangquan
 * @Description 用于
 * @Date 2022/3/16
 **/

public class UserAspect {

    private void beforeProcessMethod(JoinPoint joinPoint){
        System.out.println("beforeProcessMethod");
    }

    private void afterReturningProcessMethod(JoinPoint joinPoint,Object value){
        System.out.println("afterReturningProcessMethod");
    }

    private Object aroundProcessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aroundProcessMethod before");
        Object result = joinPoint.proceed();
        System.out.println("aroundProcessMethod after");
        return result;
    }

    private void afterThrowingEx(JoinPoint joinPoint,Exception ex){
        System.out.println("afterThrowingEx");
    }

    private void afterProcessMethod(JoinPoint joinPoint){
        System.out.println("afterProcessMethod");
    }

}
