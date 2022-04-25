package com.rabbit.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huangquan
 * @Description
 * @Date 2022/4/24
 **/

@SpringBootApplication(scanBasePackages = "com.rabbit.study.delay")
public class RabbitApp {

    public static void main(String[] args) {
        SpringApplication.run(RabbitApp.class, args);
    }

}
