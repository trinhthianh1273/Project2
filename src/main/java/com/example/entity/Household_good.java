package com.example.entity;

public class Household_good {
    private int id;
    private int category_id;
    private String name;
    private int quanty;
    private int not_used;
    private int in_used;

    public Household_good() {
    }

    public Household_good(int id, int category_id, String name, int quanty,int in_used, int not_used) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.quanty = quanty;
        this.in_used = in_used;
        this.not_used = not_used;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public int getNot_used() {
        return not_used;
    }

    public void setNot_used(int not_used) {
        this.not_used = not_used;
    }

    public int getIn_used() {
        return in_used;
    }

    public void setIn_used(int in_used) {
        this.in_used = in_used;
    }

    @Override
    public String toString() {
        return "Household_good{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                ", quanty=" + quanty +
                ", not_used=" + not_used +
                ", in_used=" + in_used +
                '}';
    }
}
