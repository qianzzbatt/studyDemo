package com.spring.study.jvm;

/**
 * @author huangquan
 * @date 2022/3/31
 **/
public class TestJvm {

    public static void main(String[] args) {
        monitorOldGc();
    }

    /**
     * -XX:NewSize=5242880                  新生代大小5M
     * -XX:MaxNewSize=5242880               新生代最大大小5M
     * -XX:InitialHeapSize=10485760         初始化堆内存10M
     * -XX:MaxHeapSize=10285760             最大堆内存10M
     * -XX:SurvivorRatio=8                  默认Eden大小占80%
     * -XX:MaxTenuringThreshold=15          进入老年代的年龄15岁
     * -XX:PretenureSizeThreshold=10485760  大对象最大阈值，大于则直接进入老年代
     * -XX:+UseParNewGC                     使用ParNew
     * -XX:+UseConcMarkSweepGC              使用CMS
     * -XX:+PrintGCDetails                  打印详细的GC日志
     * -XX:+PrintGCTimeStamps               打印每次GC发生的时间
     * -Xloggc:gc.log                       设置GC日志目录文件
     */
    public static void monitorYoungGc(){
        //1M的数组
        byte[] array1 = new byte[1024*1024];
        array1 = new byte[1024*1024];
        array1 = new byte[1024*1024];
        array1 = null;
        //2M的数组
        byte[] array2 = new byte[2*1024*1024];
    }

    /**
     * -XX:NewSize=10485760                新生代大小10M
     * -XX:MaxNewSize=10485760               新生代最大大小10M
     * -XX:InitialHeapSize=20971520         初始化堆内存20M
     * -XX:MaxHeapSize=20971520             最大堆内存20M
     * -XX:SurvivorRatio=8                  默认Eden大小占80%
     * -XX:MaxTenuringThreshold=15          进入老年代的年龄15岁
     * -XX:PretenureSizeThreshold=10485760  大对象最大阈值，大于则直接进入老年代
     * -XX:+UseParNewGC                     使用ParNew
     * -XX:+UseConcMarkSweepGC              使用CMS
     * -XX:+PrintGCDetails                  打印详细的GC日志
     * -XX:+PrintGCTimeStamps               打印每次GC发生的时间
     * -Xloggc:oldGc.log                       设置GC日志目录文件
     */
    public static void monitorOldGc(){
        //2M的数组
        byte[] array1 = new byte[2*1024*1024];
        //之前的生成的对象变成垃圾了
        array1 = new byte[2*1024*1024];
        //之前的生成的对象变成垃圾了
        array1 = new byte[2*1024*1024];
        array1 = null;
        //128KB的数组
        byte[] array2 = new byte[128*1024];
        //2M的数组 触发第一次YGC
        byte[] array3 = new byte[2*1024*1024];

        array3 = new byte[2*1024*1024];
        array3 = new byte[2*1024*1024];
        array3 = new byte[128*1024];
        array3 = null;

        byte[] array4 = new byte[2*1024*1024];

    }

}
