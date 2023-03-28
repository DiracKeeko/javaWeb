package com.keeko.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC3 {
    @Test
    public void test() {
        // 配置信息
        // useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "root";

        Connection connection = null;

        // 1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2.连接数据库,代表数据库
            connection = DriverManager.getConnection(url, username, password);

            // 3.通知数据库开启事务, false 开启
            connection.setAutoCommit(false);
            /**
             * 连续的进行插入操作，如果在开始时设置了：connection.setAutoCommit(false);
             * 最后才进行connection.commit()
             * 这样即使插入的时候报错，修改的内容也不会提交到数据库。
             *
             * 而如果没有手动的进行setAutoCommit(false);
             * 出错时就会造成，前几条插入，后几条没有
             * 会形成脏数据
             */

            String sql = "update account set money = money-100 where name = 'A'";
            connection.prepareStatement(sql).executeUpdate();

            // 制造错误
            // int i = 1/0;

            String sql2 = "update account set money = money+100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            // 以上两条SQL都执行成功了，就提交事务！
            connection.commit();
            System.out.println("success");
        } catch (Exception e) {
            try {
                // 如果出现异常，就通知数据库回滚事务
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
