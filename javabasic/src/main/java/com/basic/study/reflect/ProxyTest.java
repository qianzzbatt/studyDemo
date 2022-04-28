package com.basic.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) throws Exception {
        /*
         * 参数1：类加载器，随便给一个
         * 参数2：需要生成代理Class的接口，比如Calculator
         * */
        Class<?> calculatorProxyClazz = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);

        // 得到唯一的有参构造 $Proxy(InvocationHandler h)，和反射的Method有点像，可以理解为得到对应的构造器执行器
        Constructor<?> constructor = calculatorProxyClazz.getConstructor(InvocationHandler.class);

        // 用构造器执行器执行构造方法，得到代理对象。构造器需要InvocationHandler入参
        Calculator calculatorProxyImpl = (Calculator) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                return 10086;
            }
        });

        System.out.println(calculatorProxyImpl.add(1, 2));
    }

}