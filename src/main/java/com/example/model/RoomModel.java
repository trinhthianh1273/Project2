package com.example.model;

import com.example.common.ICommon;
import com.example.connect.DBConnect;
import com.example.entity.Manager;
import com.example.entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class RoomModel implements ICommon<Room> {
    private Connection conn=null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private int insertedId = 0;
    private String table = "room";
    @Override
    public ObservableList<Room> getAll() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        String sql = "Select room.id, room.name, room.apartment_id, room.floor, room.member_max, room.rental, room.status," +
                "apartment.name as apartment_name from " + this.table +
                " inner join apartment on room.apartment_id = apartment.id ";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                //System.out.println(room.getId());
                room.setApartment_id(rs.getInt("apartment_id"));
                room.setApartment_name(rs.getString("apartment_name"));
                room.setName(rs.getString("name"));
                room.setFloor(rs.getInt("floor"));
                room.setMember_max(rs.getInt("member_max"));
                room.setRental(rs.getInt("rental"));
                room.setStatus(rs.getInt("status"));

                sql = "select blank from contract where room_id = ?" +
                        " order by createDate desc" +
                        " limit 1";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, room.getId());
                ResultSet rs_extra = pstmt.executeQuery();
                while (rs_extra.next()) {
                    room.setBlank(rs_extra.getInt("blank"));
                }

                if(room.getStatus() == 0) {
                    room.setActual_people(0);
                } else {
                    room.setActual_people(room.getMember_max() - room.getBlank());
                }

                list.add(room);
            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return list;
    }

    public ObservableList<Room> getAllByApartmentName(String Apartment_name) {
        ObservableList<Room> list = FXCollections.observableArrayList();

        ObservableList<Room> ListAll = getAll();
        ListAll.forEach(e -> {
            if(e.getApartment_name().equals(Apartment_name) == true) {
                list.add(e);
            }
        });
        return list;
    }

    @Override
    public Room getOne(int id) {
        Room room = new Room();
        String sql = "Select * from " + this.table + " where id = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs= pstmt.executeQuery();

            while (rs.next()) {

                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setFloor(rs.getInt("floor"));
                room.setMember_max(rs.getInt("member_max"));
                room.setRental(rs.getInt("rental"));
                room.setStatus(rs.getInt("status"));

            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return room;
    }

    public ObservableList<String> getRoomNameByApartment(String apartmentName) {
        ObservableList<String> list = FXCollections.observableArrayList();
        String sql = "select room.name as name from " + this.table +
                " inner join apartment on room.apartment_id = apartment.id " +
                "where apartment.name = ?";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, apartmentName);
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

    public ObservableList<Room> getAllByFloor(int floor){
        ObservableList<Room> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table + " where floor = ?";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, floor);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setFloor(rs.getInt("floor"));
                room.setMember_max(rs.getInt("member_max"));
                room.setRental(rs.getInt("rental"));
                room.setStatus(rs.getInt("status"));

                list.add(room);
            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return list;
    }

    public ObservableList<Room> getEmptyRoom() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table + " where status = 0";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                sql = "select blank from contract where room_id = ?" +
                        " order by createDate desc" +
                        " limit 1";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, room.getId());
                ResultSet rs_extra = pstmt.executeQuery();
                while (rs_extra.next()) {
                    room.setBlank(rs_extra.getInt("blank"));
                }

                sql = "select apartment.name from apartment " +
                        " inner join room on apartment.id = room.apartment_id" +
                        " where room.id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, room.getId());
                rs_extra = pstmt.executeQuery();
                while (rs_extra.next()) {
                    room.setApartment_name(rs_extra.getString("name"));
                }

                room.setName(rs.getString("name"));
                room.setFloor(rs.getInt("floor"));
                room.setMember_max(rs.getInt("member_max"));
                room.setRental(rs.getInt("rental"));
                room.setStatus(rs.getInt("status"));
                if(room.getStatus() == 0) {
                    room.setActual_people(0);
                } else {
                    room.setActual_people(room.getMember_max() - room.getBlank());
                }

                list.add(room);
            }
        } catch (SQLException e) {

        } finally {
            DBConnect.closeResultSet(rs);
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnect(conn);
        }
        return list;
    }

    public ObservableList<Room> getRentedRoom() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        String sql = "Select * from " + this.table + " where status = 1";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                sql = "select blank from contract where id = ?" +
                        " order by createDate desc" +
                        " limit 1";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, room.getId());
                ResultSet rs_extra = pstmt.executeQuery();
                while (rs_extra.next()) {
                    room.setBlank(rs_extra.getInt("blank"));
                }

                sql = "select apartment.name from apartment " +
                        " inner join room on apartment.id = room.apartment_id" +
                        " where room.id = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, room.getId());
                rs_extra = pstmt.executeQuery();
                while (rs_extra.next()) {
                    room.setApartment_name(rs_extra.getString("name"));
                }

                room.setName(rs.getString("name"));
                room.setFloor(rs.getInt("floor"));
                room.setMember_max(rs.getInt("member_max"));
                room.setRental(rs.getInt("rental"));
                room.setStatus(rs.getInt("status"));
                if(room.getStatus() == 0) {
                    room.setActual_people(0);
                } else {
                    room.setActual_people(room.getMember_max() - room.getBlank());
                }

                list.add(room);
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
    public boolean add(Room obj) {
        String sql = "insert into " + this.table + "(apartment_id, name, floor, member_max, rental, status)" +
                " values(?, ?, ?, ?, ?, ?)";

        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, obj.getApartment_id());
            pstmt.setString(2, obj.getName());
            pstmt.setInt(3, obj.getFloor());
            pstmt.setInt(4, obj.getMember_max());
            pstmt.setInt(5, obj.getRental());
            pstmt.setInt(6, obj.getStatus());

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
    public boolean update(Room obj) {
        String sql = "update " + this.table + " set apartment_id = ?, name = ?, floor = ?, member_max = ?, rental =?, status = ?" +
                " where id = ?";
        try {
            conn = DBConnect.getConnect();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, obj.getApartment_id());
            pstmt.setString(2, obj.getName());
            pstmt.setInt(3, obj.getFloor());
            pstmt.setInt(4, obj.getMember_max());
            pstmt.setInt(5, obj.getRental());
            pstmt.setInt(6, obj.getStatus());
            pstmt.setInt(7, obj.getId());

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

    public int getTotalRoom() {
        RoomModel list = new RoomModel();
        int count = list.getAll().size();
        return count;
    }

    public static void main(String[] args) {
        RoomModel roomModel = new RoomModel();
        System.out.println(roomModel.getAllByApartmentName("HUD5"));
    }
}
