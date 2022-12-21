package com.example.entity;

public class Apartment {
    private int id;
    private String name;
    private int floor_quanty;
    private int room_quanty;

    public Apartment() {
    }

    public Apartment(int id, String name, int floor_quanty, int room_quanty) {
        this.id = id;
        this.name = name;
        this.floor_quanty = floor_quanty;
        this.room_quanty = room_quanty;
    }

    public Apartment(String name, int floor_quanty, int room_quanty) {
        this.name = name;
        this.floor_quanty = floor_quanty;
        this.room_quanty = room_quanty;
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

    public int getFloor_quanty() {
        return floor_quanty;
    }

    public void setFloor_quanty(int floor_quanty) {
        this.floor_quanty = floor_quanty;
    }

    public int getRoom_quanty() {
        return room_quanty;
    }

    public void setRoom_quanty(int room_quanty) {
        this.room_quanty = room_quanty;
    }

    @Override
    public String toString() {
        return "apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floor_quanty=" + floor_quanty +
                ", room_quanty=" + room_quanty +
                '}' + "\n";
    }
}
