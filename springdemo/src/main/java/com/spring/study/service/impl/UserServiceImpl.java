package com.spring.study.service.impl;

import com.spring.study.service.UserService;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/15
 **/

public class UserServiceImpl implements UserService {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void talk() {
        System.out.println("talk talk");
    }

    @Override
    public void bye() {
        System.out.println("bye");
    }


}
