package com.basic.study.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericClassDemo {

    public static void main(String[] args) throws Exception {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        // 编译器会阻止
        // list.add(333);
        int aa = 1;
        Object aaa = aa;
        // 但泛型约束只存在于编译期，底层仍是Object，所以运行期可以往List存入任何类型的元素
        Method addMethod = list.getClass().getDeclaredMethod("add", Object.class);
        addMethod.invoke(list, 333);

        // 打印输出观察是否成功存入Integer（注意用Object接收）
        for (Object obj : list) {
            System.out.println(obj);
        }

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        print(integerList);
        List<String> strList = new ArrayList<>();
        strList.add("4");
        print(strList);
    }

    public static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

}