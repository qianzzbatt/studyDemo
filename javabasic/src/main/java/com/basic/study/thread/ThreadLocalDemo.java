package com.basic.study.thread;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/30
 **/
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("1"));
        Thread thread2 = new Thread(() -> System.out.println("2"));
        Thread thread3 = new Thread(() -> System.out.println("3"));
        thread.start();
        thread.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        System.out.println("main begin！");
    }
}
