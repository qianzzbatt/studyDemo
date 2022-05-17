package com.basic.study.model;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/17
 **/
public class StringDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 1000000; i++) {
            str += i;
        }
        System.out.println("String 耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");

    }
}
