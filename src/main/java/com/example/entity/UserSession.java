package com.example.entity;

public class UserSession {
    private UserSession instance;
    private int userID;
    private String userName;
    private int privilege;

    public UserSession() {
    }

    public UserSession(int userID, String userName, int privilege) {
        this.userID = userID;
        this.userName = userName;
        this.privilege = privilege;
    }

    public UserSession getInstance(String userName, int id, int privilege) {
        if(instance == null) {
            instance = new UserSession(id, userName, privilege);
        }
        return instance;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void cleanUserSession() {
        userName = "";
        userID = 0;
        privilege = 0;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", privilege=" + privilege +
                '}';
    }

}
