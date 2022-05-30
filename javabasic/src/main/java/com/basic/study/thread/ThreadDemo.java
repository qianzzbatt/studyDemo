package com.basic.study.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/18
 **/
public class ThreadDemo {


    public static void main(String[] args) throws Exception {
        testUnSafeExample();
    }

    /**
     * 多线程不安全例子
     * @throws InterruptedException
     */
    public static void testUnSafeExample() throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }

}
