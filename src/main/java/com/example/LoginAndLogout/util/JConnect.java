package com.example.LoginAndLogout.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JConnect {

    private static final String URL = "jdbc:mysql://localhost:3307/demo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    protected static Connection getConnect() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return con;
        }

    }

    public static Statement getStatement() {
        try {
            return getConnect().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
