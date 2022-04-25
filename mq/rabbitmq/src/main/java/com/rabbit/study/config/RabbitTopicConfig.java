package com.rabbit.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Queue 通过 routingkey 绑定到 TopicExchange 上，
 * 当消息到达 TopicExchange 后，TopicExchange
 * 根据消息的 routingkey 将消息路由到一个或者多个 Queue 上
 */

@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME = "sang-topic";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    Queue xiaomi() {
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawei() {
        return new Queue("huawei");
    }

    @Bean
    Queue phone() {
        return new Queue("phone");
    }

    @Bean
    Binding xiaomiBinding() {
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                .with("xiaomi.#");
    }
    @Bean
    Binding huaweiBinding() {
        return BindingBuilder.bind(huawei()).to(topicExchange())
                .with("huawei.#");
    }
    @Bean
    Binding phoneBinding() {
        return BindingBuilder.bind(phone()).to(topicExchange())
                .with("#.phone.#");
    }
}