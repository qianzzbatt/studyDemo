package com.jdbc.study;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huangquan
 * @Description
 * @Date 2022/5/5
 **/
public class JdbcDemo {

    public static void main(String[] args) throws SQLException {
        //1. 创建一个 Driver 实现类的对象
        Driver driver = new Driver();

        //2. 准备连接数据库的基本信息: url, user, password
        String url = "jdbc:mysql://localhost:3306/sequelizedb";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "admin");

        //3. 调用 Driver 接口的　connect(url, info) 获取数据库连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }

}
