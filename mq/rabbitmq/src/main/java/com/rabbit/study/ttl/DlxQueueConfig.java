package com.rabbit.study.ttl;

/**
 * 死信队列
 * @author huangquan
 * @Date 2022/4/25
 *
 * 一般消息变成死信消息有如下几种情况：
 *  消息被拒绝(Basic.Reject/Basic.Nack) ，井且设置requeue 参数为false
 *  消息过期
 *  队列达到最大长度
 **/
public class DlxQueueConfig {
    
}
