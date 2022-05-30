package com.basic.study.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/26
 **/
public class ReentrantLockDemo {

    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

    }

    public void m() {
        lock.tryLock();
        lock.lock();  // block until condition holds
        try {
            // ... method body
        } finally {
            lock.unlock();
        }
    }

}
