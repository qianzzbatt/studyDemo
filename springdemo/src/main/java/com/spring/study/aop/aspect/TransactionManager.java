package com.spring.study.aop.aspect;

import com.spring.study.util.ConnectionUtils;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Component
@Aspect
public class TransactionManager {
    @Resource
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Pointcut("execution(* com.spring.study.service.impl.*.*(..))")
    private void pt1() {}

    /**
     * 开启事务
     */
    @Before("pt1()")
    public  void beginTransaction(){
        try {
            System.out.println("开启事务");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public  void commit(){
        try {
            System.out.println("提交事务");
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public  void rollback(){
        try {
            System.out.println("回滚事务");
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    @After("pt1()")
    public  void release(){
        try {
            System.out.println("释放连接");
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

