package com.rabbit.study.consumeconfirm;

import com.rabbit.study.publishconfirm.RabbitConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author huangquan
 * @Description
 * @Date 2022/4/25
 **/
public class Consume {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * basicAck：这个是手动确认消息已经成功消费，该方法有两个参数：第
     * 一个参数表示消息的 id；
     * 第二个参数 multiple 如果为 false，表示仅确认当前消息消费成功，
     * 如果为 true，则表示当前消息之前所有未被当前消费者确认的消息都消费成功。
     *
     * basicNack：这个是告诉 RabbitMQ 当前消息未被成功消费，该方法有三个参数：
     * 第一个参数表示消息的 id；第二个参数 multiple 如果为 false，表示仅拒绝当前消息的消费，
     * 如果为 true，则表示拒绝当前消息之前所有未被当前消费者确认的消息；
     * 第三个参数 requeue 含义和前面所说的一样，被拒绝的消息是否重新入队。
     *
     * @param message
     * @param channel
     */
    @RabbitListener(queues = RabbitConfig.JAVABOY_QUEUE_NAME)
    public void handle3(Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //消息消费的代码写到这里
            String s = new String(message.getBody());
            System.out.println("s = " + s);
            //消费完成后，手动 ack
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            //手动 nack
            try {
                channel.basicNack(deliveryTag, false, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //主动拉取
    public void receive2() {
        Channel channel = rabbitTemplate.getConnectionFactory().createConnection().createChannel(true);
        long deliveryTag = 0L;
        try {
            GetResponse getResponse = channel.basicGet(RabbitConfig.JAVABOY_QUEUE_NAME, false);
            deliveryTag = getResponse.getEnvelope().getDeliveryTag();
            System.out.println("o = " + new String((getResponse.getBody()), "UTF-8"));
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicNack(deliveryTag, false, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
