package com.example.entity;

import java.util.Date;

public class Contract {
    private int id;
    private int room_id;
    private int proxy_id;
    private int renter1;
    private int renter2;
    private int renter3;
    private int bed;
    private int wardrobe;
    private int fridge;
    private int titchen_infrared;
    private int pot;
    private int desk;
    private int small_table;
    private int chair;
    private Date startDate;
    private Date endDate;
    private int black;
    private int status;

    public Contract() {
    }

    public Contract(int room_id, int proxy_id, int renter1, int renter2, int renter3, int bed, int wardrobe, int fridge, int titchen_infrared, int pot, int desk, int small_table, int chair, Date startDate, Date endDate, int black, int status) {
        this.room_id = room_id;
        this.proxy_id = proxy_id;
        this.renter1 = renter1;
        this.renter2 = renter2;
        this.renter3 = renter3;
        this.bed = bed;
        this.wardrobe = wardrobe;
        this.fridge = fridge;
        this.titchen_infrared = titchen_infrared;
        this.pot = pot;
        this.desk = desk;
        this.small_table = small_table;
        this.chair = chair;
        this.startDate = startDate;
        this.endDate = endDate;
        this.black = black;
        this.status = status;
    }

    public Contract(int id, int room_id, int proxy_id, int renter1, int renter2, int renter3, int bed, int wardrobe, int fridge, int titchen_infrared, int pot, int desk, int small_table, int chair, Date startDate, Date endDate, int black, int status) {
        this.id = id;
        this.room_id = room_id;
        this.proxy_id = proxy_id;
        this.renter1 = renter1;
        this.renter2 = renter2;
        this.renter3 = renter3;
        this.bed = bed;
        this.wardrobe = wardrobe;
        this.fridge = fridge;
        this.titchen_infrared = titchen_infrared;
        this.pot = pot;
        this.desk = desk;
        this.small_table = small_table;
        this.chair = chair;
        this.startDate = startDate;
        this.endDate = endDate;
        this.black = black;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getProxy_id() {
        return proxy_id;
    }

    public void setProxy_id(int proxy_id) {
        this.proxy_id = proxy_id;
    }

    public int getRenter1() {
        return renter1;
    }

    public void setRenter1(int renter1) {
        this.renter1 = renter1;
    }

    public int getRenter2() {
        return renter2;
    }

    public void setRenter2(int renter2) {
        this.renter2 = renter2;
    }

    public int getRenter3() {
        return renter3;
    }

    public void setRenter3(int renter3) {
        this.renter3 = renter3;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getWardrobe() {
        return wardrobe;
    }

    public void setWardrobe(int wardrobe) {
        this.wardrobe = wardrobe;
    }

    public int getFridge() {
        return fridge;
    }

    public void setFridge(int fridge) {
        this.fridge = fridge;
    }

    public int getTitchen_infrared() {
        return titchen_infrared;
    }

    public void setTitchen_infrared(int titchen_infrared) {
        this.titchen_infrared = titchen_infrared;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getDesk() {
        return desk;
    }

    public void setDesk(int desk) {
        this.desk = desk;
    }

    public int getSmall_table() {
        return small_table;
    }

    public void setSmall_table(int small_table) {
        this.small_table = small_table;
    }

    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "contract{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", proxy_id=" + proxy_id +
                ", renter1=" + renter1 +
                ", renter2=" + renter2 +
                ", renter3=" + renter3 +
                ", bed=" + bed +
                ", wardrobe=" + wardrobe +
                ", fridge=" + fridge +
                ", titchen_infrared=" + titchen_infrared +
                ", pot=" + pot +
                ", desk=" + desk +
                ", small_table=" + small_table +
                ", chair=" + chair +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", black=" + black +
                ", status=" + status +
                '}' + "\n";
    }
}
