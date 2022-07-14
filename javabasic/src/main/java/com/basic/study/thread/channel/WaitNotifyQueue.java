package com.basic.study.thread.channel;

import java.util.LinkedList;

/**
 * @author huangquan
 * @date 2022/7/12
 **/
public class WaitNotifyQueue<T> {

    //消息队列
    private final LinkedList<T> queue = new LinkedList<>();

    public synchronized void put(T t) throws InterruptedException {
        while (queue.size() > 1){
            System.out.println("队列已满");
            this.wait();
        }
        System.out.println("生产消息");
        queue.addFirst(t);
        this.notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        while (queue.size() <= 0){
            System.out.println("队列没消息，等待生产");
            this.wait();
        }
        System.out.println("消费消息");
        queue.removeLast();
        this.notifyAll();
    }

}
