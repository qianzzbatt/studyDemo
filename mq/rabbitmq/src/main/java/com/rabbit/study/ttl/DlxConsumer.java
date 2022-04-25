package com.rabbit.study.ttl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DlxConsumer {
    private static final Logger logger = LoggerFactory.getLogger(DlxConsumer.class);

    @RabbitListener(queues = DlxQueueConfig.DLX_QUEUE_NAME)
    public void handle(String msg) {
        logger.info(msg);
    }
}