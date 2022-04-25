package com.rabbit.study.publishconfirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * ConfirmCallback : confirm() 确定消息到达交换器
 * ReturnsCallback : returnedMessage() 消息路由到队列失败时被调用
 *
 */

@Configuration
public class RabbitConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {
    public static final String JAVABOY_EXCHANGE_NAME = "javaboy_exchange_name";
    public static final String JAVABOY_QUEUE_NAME = "javaboy_queue_name";
    private static final Logger logger = LoggerFactory.getLogger(RabbitConfig.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    Queue queue() {
        return new Queue(JAVABOY_QUEUE_NAME);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(JAVABOY_EXCHANGE_NAME);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(JAVABOY_QUEUE_NAME);
    }

    @PostConstruct
    public void initRabbitTemplate() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.info("{}:消息成功到达交换器",correlationData.getId());
        }else{
            logger.error("{}:消息发送失败", correlationData.getId());
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        logger.error("{}:消息未成功路由到队列",returned.getMessage().getMessageProperties().getMessageId());
    }
}