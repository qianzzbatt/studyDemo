package com.basic.study.generic;

public class ObjectArray {
    public static void main(String[] args) {
        // objects其实就是对应ArrayList内部的Object[]
        Object[] objects = new Object[4];
        
        // 引入泛型后的两个作用：

        // 1.入参约束：如果是ArrayList，那么入参约束会在一开始就确定，而下面的objects就惨多了，Integer/String都可以随意出入
        objects[0] = 1;
        objects[1] = 2;
        objects[2] = "3";
        objects[3] = "4";

        // 2.自动类型转换：如果是ArrayList，由于入参已经被约束，那么返回值类型也随之确定，编译器会帮我们自动转换，无需显式地手动强转
        Integer zero = (Integer) objects[0];
        Integer one = (Integer) objects[1];
        String two = (String) objects[2];
        String three = (String) objects[3];
        Object a = 444;
        System.out.println(zero + " " + one + " " + two + " " + three);

        // 直接往String[]存Integer会编译错误
        String[] strings = new String[3];
        strings[0] = "a";
        strings[1] = "b";
        strings[2] = "22"; // COMPILE ERROR!

        // 但数组允许String[]赋值给Object[]
        Object[] fff = strings;
        // 这样就能通过编译了，但运行期会抛异常：ArrayStoreException
        objects[2] = 100;
    }
}