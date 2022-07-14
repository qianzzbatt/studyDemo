package com.basic.study.thread;

/**
 * @author huangquan
 * @date 2022/7/12
 **/
public class AsyncAndWaitTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +"主线程开始");
        Worker worker = new Worker();
        worker.begin();
        System.out.println(Thread.currentThread().getName() + "主线程结束");
        Thread.sleep(3*1000L);
    }

    static class Worker implements Runnable{

        public void begin(){
            new Thread(this).start();
        }

        /**
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"执行Worker#run()开始");
            try {
                Thread.sleep(3*1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行Worker#run()结束");
        }
    }

}
