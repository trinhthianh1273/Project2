package com.example.entity;

public class Receipt {

    private int id;
    private int contract_id;
    private int year;
    private int month;
    private int electric;
    private int water;
    private int service;
    private int forfeit;
    private int total_payment;
    private int status;
    private String description;

    public Receipt() {
    }

    public Receipt(int id, int contract_id, int year, int month, int electric, int water, int service, int forfeit, int total_payment, int status, String description) {
        this.id = id;
        this.contract_id = contract_id;
        this.year = year;
        this.month = month;
        this.electric = electric;
        this.water = water;
        this.service = service;
        this.forfeit = forfeit;
        this.total_payment = total_payment;
        this.status = status;
        this.description = description;
    }

    public Receipt(int contract_id, int year, int month, int electric, int water, int service, int forfeit, int total_payment, int status, String description) {
        this.contract_id = contract_id;
        this.year = year;
        this.month = month;
        this.electric = electric;
        this.water = water;
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

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
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
}
