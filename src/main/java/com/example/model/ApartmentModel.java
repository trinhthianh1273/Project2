package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Apartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return null;
    }

    @Override
    public boolean add(Apartment obj) {
        return false;
    }

    @Override
    public boolean update(Apartment obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean refresh() {
        return false;
    }

    public static void main(String[] args) {
        ApartmentModel apartmentModel = new ApartmentModel();
        System.out.println(apartmentModel.getAll());
    }
}
