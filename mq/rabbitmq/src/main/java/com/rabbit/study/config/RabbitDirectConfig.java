package com.rabbit.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 */
@Configuration
public class RabbitDirectConfig {

    public final static String DIRECTNAME = "javaboy-direct";

    @Bean
    Queue queue() {
        return new Queue("hello-queue");
    }

    /**
     * 三个参数分别是名字，重启后是否依然有效以及长期未用时是否删除
     * @return DirectExchange
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME, true, false);
    }

    /**
     * DirectExchange和Binding两个Bean的配置可以省略掉，即如果使用DirectExchange，
     * 可以只配置一个Queue的实例即可
     * @return
     */
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange()).with("direct");
    }
}