package com.basic.study.thread;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/18
 **/
public class ThreadUnsafeExample {


    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }

}
