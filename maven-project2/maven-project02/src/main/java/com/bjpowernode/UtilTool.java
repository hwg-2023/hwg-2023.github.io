package com.bjpowernode;

import java.sql.*;
import java.util.ResourceBundle;

public class UtilTool {
    //因为是工具类，用类调用静态方法，所以定义私有的构造方法

    public UtilTool() {}
    static {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        //获取连接
        ResourceBundle rb = ResourceBundle.getBundle("Mysql");
        String url = rb.getString("url");
        String user = rb.getString("user");
        String password = rb.getString("password");
        Connection cnn = null;

        return cnn = DriverManager.getConnection(url,user,password);
    }
    public static void close1(Statement sta,Connection cnn){
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (cnn != null){
            try {
                cnn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close2(ResultSet rs, Statement sta, Connection cnn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (cnn != null){
            try {
                cnn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
