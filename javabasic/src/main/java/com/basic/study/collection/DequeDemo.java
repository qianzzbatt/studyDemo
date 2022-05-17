package com.basic.study.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/13
 **/
public class DequeDemo {
    public static void main1(String[] args) {
        Deque<String> arrayDeque = new ArrayDeque<>(1);
        //头插
        arrayDeque.push("a");
        arrayDeque.push("b");
        arrayDeque.push("c");
        arrayDeque.push("d");
        //尾插
        arrayDeque.offerLast("e");
        arrayDeque.offerLast("f");
        arrayDeque.offerLast("g");
        arrayDeque.offerLast("h");

        //扩容 默认最小为8
        arrayDeque.push("i");
        arrayDeque.offerLast("j");
        System.out.println("数据出栈：");
        while (!arrayDeque.isEmpty()) {
            System.out.print(arrayDeque.pop() + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println((0 - 1) & (8 - 1));
    }


}
