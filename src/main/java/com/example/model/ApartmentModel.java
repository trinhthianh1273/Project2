package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Apartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ApartmentModel implements ICommon<Apartment> {
    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "apartment";
    @Override
    public ObservableList<Apartment> getAll() {
        ObservableList<Apartment> list =FXCollections.observableArrayList();
        String sql = "Select * from " + this.table;

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(rs.getInt("id"));
                apartment.setName(rs.getString("name"));
                apartment.setFloor_quanty(rs.getInt("floor_quanty"));
                apartment.setRoom_quanty(rs.getInt("room_quanty"));

                list.add(apartment);
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
    public Apartment getOne(int id) {
        Apartment apartment = new Apartment();

        String sql = "Select * from " + this.table + " where id = ?";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                apartment.setId(rs.getInt("id"));
                apartment.setName(rs.getString("name"));
                apartment.setFloor_quanty(rs.getInt("floor_quanty"));
                apartment.setRoom_quanty(rs.getInt("room_quanty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return apartment;
    }

    @Override
    public boolean add(Apartment obj) {
        String sql = "insert into " + this.table + "(name, floor_quanty, room_quanty)" +
                "values(?,?,?)";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setInt(2, obj.getFloor_quanty());
            pstmt.setInt(3, obj.getRoom_quanty());

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
    public boolean update(Apartment obj) {
        String sql = "update " + this.table +
                "set name = ?, floor_quanty + ?, room_quanty = ?, updateDate = ?" +
                "where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setInt(2, obj.getFloor_quanty());
            pstmt.setInt(3, obj.getRoom_quanty());
            pstmt.setDate(4, new Date(new java.util.Date().getTime()));
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
        ApartmentModel apartmentModel = new ApartmentModel();

        Apartment n = new Apartment("Tranh", 12, 48);
        System.out.println(apartmentModel.getAll());
    }
}
