package com.rabbit.study.receiver;

import com.rabbit.study.config.HelloWorldConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 一个队列对应了多个消费者，默认情况下，由队列对消息进行平均分配，
 * 消息会被分到不同的消费者手中。消费者可以配置各自的并发能力，
 * 进而提高消息的消费能力，也可以配置手动 ack，来决定是否要消费某一条消息
 * @author admin
 */
@Component
public class HelloWorldConsumer {

    /**
     * 第一个消费者
     *  消费 hello_world_queue
     * @param msg
     */
    @RabbitListener(queues = HelloWorldConfig.HELLO_WORLD_QUEUE_NAME)
    public void receive(String msg) {
        System.out.println("receive = " + msg);
    }

    /**
     * 第二个消费者
     *  消费 hello_world_queue
     *  concurrency: 创建10个子线程去消费消息
     * @param message
     */
    @RabbitListener(queues = HelloWorldConfig.HELLO_WORLD_QUEUE_NAME)
    public void receive2(String msg) throws IOException {
        System.out.println("receive2 = " + msg);
    }

}