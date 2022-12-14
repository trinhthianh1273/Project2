package com.example.model;

import com.example.connect.DBConnect;
import com.example.entity.Manager;
import com.example.entity.UserSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSessionModel {

    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "manager";

    public UserSession getOne(String userName, String password) {
        String sql = "Select * from " + this.table + " where login_id = ? AND pass = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserSession userSession = new UserSession(rs.getInt("id"), rs.getString("name"), rs.getInt("permission"));
                return userSession;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return null;
    }
}
