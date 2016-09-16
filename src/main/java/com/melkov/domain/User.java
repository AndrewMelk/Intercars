package com.melkov.domain;

/**
 * Created by andrew on 11.08.16.
 */
public class User {

    private long id;
    private String userName;
    private String userEmail;
    private String userPass;

    public User(long id, String userName, String userEmail, String userPass) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPass = userPass;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
