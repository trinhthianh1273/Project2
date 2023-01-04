package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Apartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.sql.Date;
import java.util.*;

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

    public ObservableList<String> getApartmentName() {
        ObservableList<String> list =FXCollections.observableArrayList();
        String sql = "Select name from " + this.table;
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {

                list.add(rs.getString("name"));
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

    public int apartmentTotal() {
        int count = 0;
        String sql = "select count(id) as count from " + this.table;
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                count += rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return count;
    }

    public int roomTotal() {
        int count = 0;
        String sql = "select sum(room_quanty) as sum from " + this.table;
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                count += rs.getInt("sum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return count;
    }

    public int renterTotal() {
        int count = 0;
        String sql = "select count(id) as count from renter where status = 1";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                count += rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return count;
    }

    public String bestRevenued() {
        int maxY = 0;
        int maxM = 0;
        String sqlY = "select max(year) as maxY from apartment.receipt";
        String sqlM = "select max(month) as maxM from apartment.receipt";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sqlY);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                maxY = rs.getInt("maxY");
            }

            pstmt = conn.prepareStatement(sqlM);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                maxM = rs.getInt("maxM");
            }

            String sql = "select sum(total_payment) as sum from apartment.receipt " +
                    "inner join contract on receipt.contract_id = contract.id " +
                    "inner join room on contract.room_id = room.id " +
                    "inner join apartment on room.apartment_id = apartment.id " +
                    "where year = ? and month = ? and  apartment.id = ?";

            ObservableList<Apartment> list = this.getAll();

            TreeMap<Integer, String> listRevenued = new TreeMap<>();
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maxY);
            pstmt.setInt(2, maxM);

            list.forEach(item -> {
                try {
                    pstmt.setInt(3, item.getId());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int sum = rs.getInt("sum");
                        listRevenued.put(sum, item.getName());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            //System.out.println(listRevenued.values().toArray()[listRevenued.size() - 1]);
            return listRevenued.values().toArray()[listRevenued.size() - 1].toString();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return null;
    }

    public boolean checkNewApartment(String name) {
        String sql = "Select id from " + this.table + " where name = ?";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return true;
    }

    public static void main(String[] args) {
        ApartmentModel apartmentModel = new ApartmentModel();

        Apartment n = new Apartment("Tranh", 12, 48);
        System.out.println(apartmentModel.getApartmentName());
    }

}
