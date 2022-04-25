package com.spring.study.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author huangquan
 * @Description
 * @Date 2022/3/16
 **/
public class UserAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Around Before");
        Object result = invocation.proceed();
        System.out.println("Around After");
        return result;
    }
}
