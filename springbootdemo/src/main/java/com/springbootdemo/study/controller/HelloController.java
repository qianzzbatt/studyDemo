package com.springbootdemo.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangquan
 * @Description
 * @Date 2022/6/15
 **/

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return"hello";
    }

}
