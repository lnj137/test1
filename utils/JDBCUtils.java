package com.nj.utils;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:18
 */
public class JDBCUtils {

    /*连接数据库的方式*/
    public static Connection getConnection() throws Exception {
        // 1.创建Properties对象，读取配置文件中的配置信息
        Properties pros = new Properties();
        pros.load(JDBCUtils.class.getClassLoader()
                .getResourceAsStream("db.properties"));

        String driverClass = pros.getProperty("driver");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /*关闭资源的方法*/
    public static void close(ResultSet rs , PreparedStatement ps, Connection conn){
        /*关闭资源的时候  先开的后关*/
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
