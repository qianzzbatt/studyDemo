package com.spring.study.util;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 数据库连接工具类
 * @author https://www.imooc.com/wiki/springlesson/aopan.html
 */

@Component
public class ConnectionUtils {

    private final ThreadLocal<Connection> currentConnection = new ThreadLocal<Connection>();

    @Resource
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        try{
            //1.先从ThreadLocal上获取
            Connection conn = currentConnection.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                conn.setAutoCommit(false);
                currentConnection.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑 避免内存泄漏
     */
    public void removeConnection(){
        currentConnection.remove();
    }
}
