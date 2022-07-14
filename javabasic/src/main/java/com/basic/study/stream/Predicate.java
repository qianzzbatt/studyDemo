package com.basic.study.stream;

/**
 * 新建Predicate接口
 *
 * @param <T>
 */
@FunctionalInterface
interface Predicate<T> {
    /**
     * 定义了一个test()方法，传入任意对象，返回true or false，具体判断逻辑由子类实现
     *
     * @param t
     * @return
     */
    boolean test(T t);
}