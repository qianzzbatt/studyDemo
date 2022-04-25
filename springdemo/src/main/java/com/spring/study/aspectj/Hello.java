package com.spring.study.aspectj;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/17
 **/
public class Hello {

    public void helloAspectJ(){
        System.out.println("helloAspectJ");
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.helloAspectJ();
    }

}
