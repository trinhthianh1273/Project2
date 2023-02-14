package com.example.entity;

public class Receipt {

    private int id;
    private int contract_id;
    private int year;
    private int month;
    private int electricOld;
    private int electricNew;
    private int waterOld;
    private int waterNew;
    private int service;
    private int forfeit;
    private int total_payment;
    private int status;
    private String description;

    private String room;
    private int electricFee;
    private int waterFee;
    private String time;


    public Receipt() {
    }

    public Receipt(int id, int contract_id, int year, int month, int electricOld, int electricNew, int waterOld, int waterNew, int service, int forfeit, int total_payment, int status, String description) {
        this.id = id;
        this.contract_id = contract_id;
        this.year = year;
        this.month = month;
        this.electricOld = electricOld;
        this.electricNew = electricNew;
        this.waterOld = waterOld;
        this.waterNew = waterNew;
        this.service = service;
        this.forfeit = forfeit;
        this.total_payment = total_payment;
        this.status = status;
        this.description = description;
    }

    public Receipt(int contract_id, int year, int month, int electricOld, int electricNew, int waterOld, int waterNew, int service, int forfeit, int total_payment, int status, String description) {
        this.contract_id = contract_id;
        this.year = year;
        this.month = month;
        this.electricOld = electricOld;
        this.electricNew = electricNew;
        this.waterOld = waterOld;
        this.waterNew = waterNew;
        this.service = service;
        this.forfeit = forfeit;
        this.total_payment = total_payment;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getElectricOld() {
        return electricOld;
    }

    public void setElectricOld(int electricOld) {
        this.electricOld = electricOld;
    }

    public int getElectricNew() {
        return electricNew;
    }

    public void setElectricNew(int electricNew) {
        this.electricNew = electricNew;
    }

    public int getWaterOld() {
        return waterOld;
    }

    public void setWaterOld(int waterOld) {
        this.waterOld = waterOld;
    }

    public int getWaterNew() {
        return waterNew;
    }

    public void setWaterNew(int waterNew) {
        this.waterNew = waterNew;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getForfeit() {
        return forfeit;
    }

    public void setForfeit(int forfeit) {
        this.forfeit = forfeit;
    }

    public int getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(int total_payment) {
        this.total_payment = total_payment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getElectricFee() {
        return electricFee;
    }

    public void setElectricFee(int electricFee) {
        this.electricFee = electricFee;
    }

    public int getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(int waterFee) {
        this.waterFee = waterFee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", contract_id=" + contract_id +
                ", year=" + year +
                ", month=" + month +
                ", electricOld=" + electricOld +
                ", electricNew=" + electricNew +
                ", waterOld=" + waterOld +
                ", waterNew=" + waterNew +
                ", service=" + service +
                ", forfeit=" + forfeit +
                ", total_payment=" + total_payment +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", room='" + room + '\'' +
                ", electricFee=" + electricFee +
                ", waterFee=" + waterFee +
                ", time='" + time + '\'' +
                '}' + "\n";
    }
}
