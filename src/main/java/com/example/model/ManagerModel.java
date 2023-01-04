package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Manager;
import com.example.entity.Renter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ManagerModel implements ICommon<Manager> {
    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "manager";

    @Override
    public ObservableList<Manager> getAll() {
        ObservableList<Manager> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table;

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Manager manager = new Manager();
                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setLogin_id(rs.getString("login_id"));
                manager.setPass(rs.getString("pass"));
                manager.setPermission(rs.getInt("permission"));

                list.add(manager);
            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return list;
    }

    @Override
    public Manager getOne(int id) {
        Manager manager = new Manager();
        String sql = "Select * from " + this.table + " where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs= pstmt.executeQuery();

            while (rs.next()) {

                manager.setId(rs.getInt("id"));
                manager.setName(rs.getString("name"));
                manager.setLogin_id(rs.getString("login_id"));
                manager.setPass(rs.getString("pass"));
                manager.setPermission(rs.getInt("permission"));

            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return manager;
    }

    @Override
    public boolean add(Manager obj) {
        String sql = "insert into " + this.table + "(name, login_id, pass, permission)" +
                "values(?, ?, ?, ?)";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getLogin_id());
            pstmt.setString(3, obj.getPass());
            pstmt.setInt(4, obj.getPermission());

            int row = pstmt.executeUpdate();
            if(row == 1) {
                System.out.println("Insert successfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return false;
    }

    @Override
    public boolean update(Manager obj) {
        String sql = "update " + this.table + " set name = ?, login_id = ?, pass = ?, permission = ?" +
                " where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getLogin_id());
            pstmt.setString(3, obj.getPass());
            pstmt.setInt(4, obj.getPermission());
            pstmt.setInt(5, obj.getId());

            int row = pstmt.executeUpdate();
            if(row == 1) {
                System.out.println("update successfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from " + this.table + " where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, id);
            int row = pstmt.executeUpdate();
            if(row == 1) {
                System.out.println("delete successfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return false;
    }

    @Override
    public boolean refresh() {
        return false;
    }

    public static void main(String[] args) {
        ManagerModel managerModel = new ManagerModel();

        Manager manager = new Manager(5, "Tran Bao Trung", "tbt", "1234567890", 2);
        System.out.println(managerModel.getAll());
    }
}
