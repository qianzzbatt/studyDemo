package com.basic.study.thread.channel;

import java.util.LinkedList;

/**
 * @author huangquan
 * @date 2022/7/12
 **/
public class WhileQueue<T> {

    //消息队列
    private final LinkedList<T> queue = new LinkedList<>();

    public void put(T t){
        while (queue.size() > 1){
            System.out.println("队列已满请先消费!");
        }
        System.out.println("生产一条消息");
        queue.addFirst(t);
    }

    public void get(){
        while (queue.size() <=0 ){
            System.out.println("队列没有消息请先生产!");
        }
        System.out.println("消费一条消息");
        queue.removeLast();
    }

}
