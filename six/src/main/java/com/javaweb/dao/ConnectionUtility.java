package com.javaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtility {

    private static Connection cn;

    public static Connection getConnection(){
        if (cn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "", "");
                cn.setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cn;
    }

/*    public static Connection getConnection(){
        if (cn == null) {
            try {
                Properties props = new Properties();
                props.load(ConnectionUtility.class.getResourceAsStream("src/main/resources/mysql.props"));
                Class.forName(props.getProperty("db.driver"));
                cn = DriverManager.getConnection(props.getProperty("db.url"),
                        props.getProperty("db.username"), props.getProperty("db.password"));
                cn.setAutoCommit(false);
                } catch (Exception e) {
                e.printStackTrace();
            }}
            return cn;
            }*/
}
