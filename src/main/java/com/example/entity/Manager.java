package com.example.entity;
public class Manager {
    private int id;
    private String name;
    private String login_id;
    private String pass;
    private int permission;

    public Manager() {
    }

    public Manager(int id, String name, String login_id, String pass, int permission) {
        this.id = id;
        this.name = name;
        this.login_id = login_id;
        this.pass = pass;
        this.permission = permission;
    }

    public Manager(String name, String login_id, String pass, int permission) {
        this.name = name;
        this.login_id = login_id;
        this.pass = pass;
        this.permission = permission;
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

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login_id='" + login_id + '\'' +
                ", pass='" + pass + '\'' +
                ", permission=" + permission +
                '}' + "\n";
    }
}
