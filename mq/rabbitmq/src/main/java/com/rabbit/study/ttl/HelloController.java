package com.rabbit.study.ttl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/hello")
    public void hello() {
        Message message = MessageBuilder.withBody("hello javaboy".getBytes())
                .setExpiration("10000")
                .build();
        rabbitTemplate.convertAndSend(QueueConfig.JAVABOY_QUEUE_DEMO, message);
    }
}