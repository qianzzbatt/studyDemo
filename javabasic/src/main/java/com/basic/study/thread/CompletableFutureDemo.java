package com.basic.study.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author huangquan
 * @Description
 * @Date 2022/6/2
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


    }

    //whenComplete:结果获得后执行   exceptionally:报错之后执行
    public static void whenComplete(){
        CompletableFuture.supplyAsync(() ->{
            String result = "data";
            return result;
        }).whenComplete((r,e) ->{
            //拿到结果执行后面的任务

        }).exceptionally(e->{
            //异常处理
            return null;
        });
    }

    //获取结果
    //join:编译期间不做异常检查 和get区别
    public static void getResult(){
    }

    //拿到结果后处理结果

    //
}
