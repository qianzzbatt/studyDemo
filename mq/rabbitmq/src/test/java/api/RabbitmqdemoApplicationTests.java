package api;

import com.rabbit.study.RabbitApp;
import com.rabbit.study.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = RabbitApp.class)
class RabbitmqdemoApplicationTests {

    @Resource
    RabbitTemplate rabbitTemplate;


    @Test
    void contextLoads() {
        //默认的直连交换机（DirectExchange）:
        /*DirectExchange 的路由策略是将消息队列绑定到一个 DirectExchange 上，
         当一条消息到达 DirectExchange 时会被转发到与该条消息 routing key 相同的 Queue 上，
         例如消息队列名为 “hello-queue”，则 routingkey 为 “hello-queue” 的消息会被该消息队列接收*/
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(HelloWorldConfig.HELLO_WORLD_QUEUE_NAME, "hello");
        }
    }

    @Test
    public void directTest() {
        rabbitTemplate.convertAndSend(RabbitDirectConfig.DIRECTNAME,"direct", "hello direct!");
    }

    @Test
    public void fanoutTest() {
        rabbitTemplate
                .convertAndSend(RabbitFanoutConfig.FANOUTNAME,
                        null, "hello fanout!");
    }

    @Test
    public void topicTest() {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "xiaomi.news","小米新闻..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "huawei.news","华为新闻..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "xiaomi.phone","小米手机..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "huawei.phone","华为手机..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
                "phone.news","手机新闻..");
    }

    @Test
    public void headerTest() {
        Message nameMsg = MessageBuilder
                .withBody("hello header! name-queue".getBytes())
                .setHeader("name", "sang").build();
        Message ageMsg = MessageBuilder
                .withBody("hello header! age-queue".getBytes())
                .setHeader("age", "99").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, ageMsg);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME, null, nameMsg);
    }

}