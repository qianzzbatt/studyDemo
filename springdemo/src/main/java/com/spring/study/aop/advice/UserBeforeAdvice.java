package com.spring.study.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/16
 **/
public class UserBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("beforeMethodProcess");
    }
}
