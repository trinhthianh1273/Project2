package com.example.connect;

import com.example.config.IConfig;

import java.sql.*;

public class DBConnect {

    Connection conn = null;

    public static Connection getConnect() {
        Connection conn = null;

        // jdbc:mysql://localhost:3306/connect
        String url = "jdbc:mysql://"
                + IConfig.HOSTNAME + ":"
                + IConfig.PORT + "/"
                + IConfig.DBNAME;

        try {
            conn = DriverManager.getConnection(url, IConfig.USER, IConfig.PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null) {
                System.out.println("Connect successfully.");
            }
        }
        return conn;
    }

    public static void closeConnect(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Close ResultSet fails");
        }
    }

    public static void closePreparedStatement(PreparedStatement pstmt) {
        try {
            if(pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Close PreparedStatement fails.");
        }
    }

}
