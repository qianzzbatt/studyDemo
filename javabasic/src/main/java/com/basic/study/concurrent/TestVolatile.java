package com.basic.study.concurrent;

public class TestVolatile {
    int a = 1;
    boolean status = false;
    //状态切换为true
    public void changeStatus() {
        //1
        a = 2;
        // 2
        status = true;

    }
    // 若状态为true，则为running
    public void run() {
        if (status) {
            // 3
            int b = a + 1;
            //4
            System.out.println(b);
        }
    }
}