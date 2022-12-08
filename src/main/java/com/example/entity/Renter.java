package com.example.entity;

import java.util.Date;

public class Renter {
    private int id;
    private String name;
    private String phone;
    private String email;
    private int status;
    private Date dob;
    private String province;
    private String district;
    private String commune;
    private String address;
    private int gender;

    public Renter() {
    }

    public Renter(String name, String phone, String email, int status, Date dob, String province, String district, String commune, String address, int gender) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.dob = dob;
        this.province = province;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.gender = gender;
    }

    public Renter(int id, String name, String phone, String email, int status, Date dob, String province, String district, String commune, String address, int gender) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.dob = dob;
        this.province = province;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
