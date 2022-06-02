package com.basic.study.thread;

/**
 * @author huangquan
 * @Description
 * @Date 2022/6/1
 **/
public class DeadLock {

    // 定义两个Object对象，模拟两个线程占有的资源
    public static final Object o1 = new Object();
    public static final Object o2 = new Object();


    public static void main(String[] args) {
        new Thread(()->{
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("2");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("2");
                }
            }
        }).start();
    }

}
