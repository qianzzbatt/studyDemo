package com.spring.study.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/16
 **/
public class UserThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing( Method method, Object[] args, Object target, Exception ex){
        System.out.println("afterThrowing");
    }

}
