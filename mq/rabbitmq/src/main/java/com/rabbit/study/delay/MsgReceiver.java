package com.rabbit.study.delay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void handleMsg(String msg) {
        logger.info("handleMsg,{}",msg);
    }
}