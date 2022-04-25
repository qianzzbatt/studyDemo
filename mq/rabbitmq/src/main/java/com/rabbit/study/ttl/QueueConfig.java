package com.rabbit.study.ttl;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QueueConfig {

    public static final String JAVABOY_QUEUE_DEMO = "javaboy_queue_demo";
    public static final String JAVABOY_EXCHANGE_DEMO = "javaboy_exchange_demo";
    public static final String HELLO_ROUTING_KEY = "hello_routing_key";

    /**
     *  消息队列的名字
     *  消息是否持久化 : true/false
     *  消息队列是否排他: true/false
     *  该队列没有任何订阅的消费者的话，该队列会被自动删除，一般适用于临时队列 : true/false
     *
     *
     * (
     *  关于排他性，如果设置为 true，则该消息队列只有创建它的 Connection 才能访问，
     *  其他的 Connection 都不能访问该消息队列，如果试图在不同的连接中重新声明或者访问排他性队列，
     *  那么系统会报一个资源被锁定的错误。另一方面，对于排他性队列而言，当连接断掉的时候，
     *  该消息队列也会自动删除（无论该队列是否被声明为持久性队列都会被删除）
     * )
     * @return
     */
    @Bean
    Queue queue() {
        //设置队列过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 10000);
        return new Queue(JAVABOY_QUEUE_DEMO, true, false, false,args);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(JAVABOY_EXCHANGE_DEMO, true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(HELLO_ROUTING_KEY);
    }
}