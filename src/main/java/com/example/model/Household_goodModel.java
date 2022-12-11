package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Household_good;
import com.example.entity.Renter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Household_goodModel implements ICommon<Household_good> {
    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "household_good";

    @Override
    public ObservableList<Household_good> getAll() {
        ObservableList<Household_good> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table;

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Household_good household_good = new Household_good();
                household_good.setName(rs.getString("name"));
                household_good.setQuanty(rs.getInt("quanty"));
                household_good.setNot_used(rs.getInt("not_use"));

                list.add(household_good);
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
    public Household_good getOne(int id) {
        Household_good household_good = new Household_good();
        String sql = "Select * from " + this.table + " where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);

            rs= pstmt.executeQuery();

            while (rs.next()) {

                household_good.setName(rs.getString("name"));
                household_good.setQuanty(rs.getInt("quanty"));
                household_good.setNot_used(rs.getInt("not_use"));

            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return household_good;
    }

    @Override
    public boolean add(Household_good obj) {
        return false;
    }

    @Override
    public boolean update(Household_good obj) {
        String sql = "update " + this.table + "set quanty = ?, not_used = ?" ;
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, obj.getQuanty());
            pstmt.setInt(2, obj.getNot_used());

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
        return false;
    }

    @Override
    public boolean refresh() {
        return false;
    }
}
