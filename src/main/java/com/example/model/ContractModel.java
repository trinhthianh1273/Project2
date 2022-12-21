package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Apartment;
import com.example.entity.Contract;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractModel implements ICommon<Contract> {
    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "contract";

    @Override
    public ObservableList<Contract> getAll() {
        ObservableList<Contract> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table;

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Contract contract = new Contract();
                contract.setId(rs.getInt("id"));
                contract.setRoom_id(rs.getInt("room_id"));
                contract.setProxy_id(rs.getInt("proxy_id"));
                contract.setRenter1(rs.getInt("renter1"));
                contract.setRenter2(rs.getInt("renter2"));
                contract.setRenter3(rs.getInt("renter3"));
                contract.setBed(rs.getInt("bed"));
                contract.setWardrobe(rs.getInt("wardrobe"));
                contract.setFridge(rs.getInt("fridge"));
                contract.setTitchen_infrared(rs.getInt("titchen_infrared"));
                contract.setPot(rs.getInt("pot"));
                contract.setDesk(rs.getInt("desk"));
                contract.setSmall_table(rs.getInt("small_table"));
                contract.setChair(rs.getInt("chair"));
                contract.setStartDate(rs.getDate("startDate"));
                contract.setEndDate(rs.getDate("endDate"));
                contract.setBlack(rs.getInt("blank"));
                contract.setStatus(rs.getInt("status"));

                list.add(contract);
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
    public Contract getOne(int id) {
        Contract contract = new Contract();

        String sql = "Select * from " + this.table + " where id = ?";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                contract.setId(rs.getInt("id"));
                contract.setRoom_id(rs.getInt("room_id"));
                contract.setProxy_id(rs.getInt("proxy_id"));
                contract.setRenter1(rs.getInt("renter1"));
                contract.setRenter2(rs.getInt("renter2"));
                contract.setRenter3(rs.getInt("renter3"));
                contract.setBed(rs.getInt("bed"));
                contract.setWardrobe(rs.getInt("wardrobe"));
                contract.setFridge(rs.getInt("fridge"));
                contract.setTitchen_infrared(rs.getInt("titchen_infrared"));
                contract.setPot(rs.getInt("pot"));
                contract.setDesk(rs.getInt("desk"));
                contract.setSmall_table(rs.getInt("small_table"));
                contract.setChair(rs.getInt("chair"));
                contract.setStartDate(rs.getDate("startDate"));
                contract.setEndDate(rs.getDate("endDate"));
                contract.setBlack(rs.getInt("blank"));
                contract.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return contract;
    }

    @Override
    public boolean add(Contract obj) {
        String sql = "insert into " + this.table + "(room_id, proxy_id, renter1, renter2, renter3, bed, wardrobe, fridge, titchen_infrared, pot, desk, small_table, chair, startDate, endDate, blank, status)" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean update(Contract obj) {
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
        ContractModel contractModel = new ContractModel();
        System.out.println(contractModel.getOne(12));
    }
}
