package com.spring.study.aspectj;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/17
 **/

public aspect HelloAspect {

    pointcut helloPointcut():execution(void Hello.helloAspectJ());
    after():helloPointcut(){
        System.out.println("****after****");
    }
    before():helloPointcut(){
        System.out.println("****before****");
    }
    void around():helloPointcut(){
        System.out.println("around before ...");
        proceed();
        System.out.println("around after ...");
    }

}
