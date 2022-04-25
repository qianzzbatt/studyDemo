package com.rabbit.study.delay;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用rabbitmq_delayed_message_exchange插件实现延时队列
 * 安装插件后需要重启
 */


@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "javaboy_delay_queue";
    public static final String EXCHANGE_NAME = "javaboy_delay_exchange";
    public static final String EXCHANGE_TYPE = "x-delayed-message";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    /**
     * params:
     * 交换机名称。
     * 交换机类型，这个地方是固定的。
     * 交换机是否持久化。
     * 如果没有队列绑定到交换机，交换机是否删除。
     * 其他参数。
     *
     * x-delayed-type : 最后一个 args 参数中，指定了交换机消息分发的类型，这
     *                  个类型就是大家熟知的 direct、fanout、topic 以及 header 几种，
     *                  用了哪种类型，将来交换机分发消息就按哪种方式来
     * @return
     */
    @Bean
    CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(EXCHANGE_NAME, EXCHANGE_TYPE, true, false,args);
    }
    
    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(customExchange()).with(QUEUE_NAME).noargs();
    }
}