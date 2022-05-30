package com.basic.study.model;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/17
 **/
public class StringDemo {
    public static void main(String[] args) {
/*        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 1000000; i++) {
            str += i;
        }
        System.out.println("String 耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");*/



        String str_1 = new String("ab");
        String str_2 = new String("ab");
        String str_3 = "ab";

        System.out.println(str_1 == str_2);
        System.out.println(str_1 == str_2.intern());
        System.out.println(str_1.intern() == str_2.intern());
        System.out.println(str_1 == str_3);
        System.out.println(str_1.intern() == str_3);

    }
}
