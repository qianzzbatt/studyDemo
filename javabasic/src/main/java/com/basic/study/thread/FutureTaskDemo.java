package com.basic.study.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author huangquan
 * @Description
 * @Date 2022/6/2
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            System.out.println("gg");
            return "null";
        });
        threadPool.submit(stringFutureTask);
        threadPool.shutdown();
        //此时发生阻塞，会影响后面的语句输出，最好别直接调用get方法
        System.out.println(stringFutureTask.get());
        //异步任务完成后再获取结果
        while (true) {
            if (stringFutureTask.isDone()){
                System.out.println(stringFutureTask.get());
            }else {
                System.out.println("正在查询中");
            }
        }

    }
}
