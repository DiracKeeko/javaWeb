package com.keeko.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块同类初始化，在类加载的时候就初始化
    static {
        //通过类加载器去读取对应的资源
        ClassLoader loader = BaseDao.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //获取数据库的连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 编写查询的公共类
    public static ResultSet execute(Connection connection, String sql, Object[] param, PreparedStatement statement, ResultSet resultSet) {
        try {
            // 预编译的sql，执行的时候不需要传sql
            statement = connection.prepareStatement(sql);
            // setObject,占位符从1开始，参数下标从0开始
            for (int i = 0; i < param.length; i++) {
                statement.setObject(i + 1, param[i]);
            }
            resultSet = statement.executeQuery(); // 预编译的sql，执行的时候不需要传sql
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // 编写增删改的公共方法
    public static int update(Connection connection, String sql, Object[] param, PreparedStatement statement) {
        int resultNum = 0;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                statement.setObject(i + 1, param[i]);
            }
            resultNum = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultNum;
    }

    // 关闭资源的公共方法
    public static boolean closeResource(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        boolean flag = true;
        if (resultSet != null) {
            try {
                resultSet.close();
                //垃圾回收的操作
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                //如果没有释放成功
                flag = false;
            }
        }
        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }
}
