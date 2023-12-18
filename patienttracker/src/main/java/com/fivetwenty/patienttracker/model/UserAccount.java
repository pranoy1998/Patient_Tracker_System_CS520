package com.fivetwenty.patienttracker.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "useraccount")
public class UserAccount {
    @Id
    private int userid;
    private String username;
    private String password;
    private String role;

    public UserAccount(){

    }

    public UserAccount(int userId, String username, String password, String role) {
        this.userid = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters for each field

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString() method to represent object details

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
