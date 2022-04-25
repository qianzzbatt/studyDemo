package com.spring.study.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/16
 **/
public class UserAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("afterMethodProcess");
    }
}
