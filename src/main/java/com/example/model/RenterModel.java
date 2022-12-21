package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Apartment;
import com.example.entity.Renter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RenterModel implements ICommon<Renter> {
    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "renter";
    @Override
    public ObservableList<Renter> getAll() {
        ObservableList<Renter> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table;

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Renter renter = new Renter();
                renter.setId(rs.getInt("id"));
                renter.setName(rs.getString("name"));
                renter.setPhone(rs.getString("phone"));
                renter.setEmail(rs.getString("email"));
                renter.setStatus(rs.getInt("status"));
                renter.setDob(rs.getDate("dob"));
                renter.setProvince(rs.getString("province"));
                renter.setDistrict(rs.getString("district"));
                renter.setCommune(rs.getString("commune"));
                renter.setAddress(rs.getString("address"));
                renter.setGender(rs.getInt("gender"));

                list.add(renter);
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
    public Renter getOne(int id) {
        Renter renter = new Renter();
        String sql = "Select * from " + this.table + " where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                renter.setId(rs.getInt("id"));
                renter.setName(rs.getString("name"));
                renter.setPhone(rs.getString("phone"));
                renter.setEmail(rs.getString("email"));
                renter.setStatus(rs.getInt("status"));
                renter.setProvince(rs.getString("province"));
                System.out.println(rs.getString("province"));
                renter.setDistrict(rs.getString("district"));
                renter.setCommune(rs.getString("commune"));
                renter.setAddress(rs.getString("address"));
                renter.setGender(rs.getInt("gender"));

            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return renter;
    }

    @Override
    public boolean add(Renter obj) {
        String sql = "insert into renter(name, phone, email, status, dob, province, district, commune, address, gender)" +
                " values(?,?,?,?,?,?,?,?,?,?)";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getPhone());
            pstmt.setString(3, obj.getEmail());
            pstmt.setInt(4, obj.getStatus());
            pstmt.setDate(5, new Date(obj.getDob().getTime()));
            pstmt.setString(6, obj.getProvince());
            pstmt.setString(7, obj.getDistrict());
            pstmt.setString(8, obj.getCommune());
            pstmt.setString(9, obj.getAddress());
            pstmt.setInt(10, obj.getGender());

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
    public boolean update(Renter obj) {
        String sql = "update " + this.table +
                "set name = ?, phone = ? , email = ?, status = ?, dob = ?, province = ?, district = ?, commune = ?, address = ?, gender = ?, updateDate = ?" +
                "where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getPhone());
            pstmt.setString(3, obj.getEmail());
            pstmt.setInt(4, obj.getStatus());
            pstmt.setDate(5, (Date) obj.getDob());
            pstmt.setString(6, obj.getProvince());
            pstmt.setString(7, obj.getDistrict());
            pstmt.setString(8, obj.getCommune());
            pstmt.setString(9, obj.getAddress());
            pstmt.setInt(10, obj.getGender());
            pstmt.setDate(11, new Date(new java.util.Date().getTime()));
            pstmt.setInt(12, obj.getId());

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

    public static void main(String[] args) throws ParseException {
        RenterModel renterModel = new RenterModel();
        java.util.Date date = new SimpleDateFormat("yyyy-MM-yy").parse("12-12-2022");
        Renter r = new Renter("Nguyen Hoang Nam", "0123456789", "nguyenhoangnam@gmail.com", 1, date, "Thai Nguyen", "TP Thai Nguyen", "", "", 1);
        System.out.println(renterModel.delete(32));
    }
}
