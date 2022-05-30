package com.basic.study.concurrent;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/20
 **/
public class SynchronizedDemo {

    private int count;

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class){
            System.out.println(1);
        }
    }

    public synchronized void add(){
        count++;
    }

}
