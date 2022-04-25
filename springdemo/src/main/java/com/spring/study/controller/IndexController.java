package com.spring.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangquan
 * @Description
 * @Date 2022/3/15
 **/

@RequestMapping("/api/index")
@RestController
public class IndexController {
    
    @GetMapping("/hello")
    public void hello() {
        System.out.println("hello");
    }


    
}
