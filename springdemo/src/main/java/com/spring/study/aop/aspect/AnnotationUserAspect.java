package com.spring.study.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/17
 **/

@Aspect
@Component
public class AnnotationUserAspect {

    /**
     * 定义切点 execution以表达式匹配规则
     * 匹配这个路径下所有方法
     */
    @Pointcut("execution(* com.spring.study.service.impl.*.*(..))")
    public void allServicePointcut(){
    }

    /**
     * 定义切点 execution以表达式匹配规则
     * 匹配这个路径下所有类中 sayHello方法
     */
    @Pointcut("execution(* com.spring.study.service.impl.*.sayHello(..))")
    public void allServiceSayHelloPointcut(){
    }

    /**
     * 定义切点 execution以表达式匹配规则
     * 匹配这个路径下所有类中 talk方法
     */
    @Pointcut("execution(* com.spring.study.service.impl.*.talk(..))")
    public void allServiceTalkPointcut(){
    }

    /**
     * 定义前置通知 并应用切点
     */
    @Before("allServiceSayHelloPointcut()")
    public void beforeProcessMethod(JoinPoint joinPoint){
        System.out.println("beforeProcessMethod");
    }

    /**
     * 定义后置返回通知 并应用切点
     */
    @AfterReturning(pointcut = "allServicePointcut()",returning = "value")
    public void afterReturningMethod(JoinPoint joinPoint,Object value){
        System.out.println("afterReturningMethod");
    }

    /**
     * 定义后置通知 并应用切点 表达式的组合 &&,||,!这几种
     */
    @After("allServiceSayHelloPointcut()||allServiceTalkPointcut()")
    public void afterProcessMethod(JoinPoint joinPoint){
        System.out.println("afterProcessMethod");
    }

    /**
     * 环绕通知 并应用切点
     */
    @Around("allServiceSayHelloPointcut()")
    public Object aroundProcessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aroundProcessMethod before");
        Object result = joinPoint.proceed();
        System.out.println("aroundProcessMethod after");
        return result;
    }

    /**
     * 定义后置异常通知 并应用切点
     */
    @AfterThrowing(pointcut = "allServicePointcut()",throwing = "ex")
    public void AfterThrowingMethod(JoinPoint joinPoint,Exception ex){
        System.out.println("AfterThrowingMethod");
    }

}
