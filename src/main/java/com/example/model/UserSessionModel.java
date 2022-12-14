package com.example.model;

import com.example.entity.Manager;
import com.example.entity.UserSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSessionModel {

    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "manager";

    public UserSession getOne(String userName, String password) {
        UserSession manager = new UserSession();
        String sql = "Select * from " + this.table + " where ";
        return null;
    }
}
