package org.launchcode.spaday.models;

import java.time.LocalDate;

public class User {
    private String username;
    private String email;
    private String password;

    private final String dateJoined;
    private final int id;
    private static int nextId = 1;

    public User() {
        this.dateJoined = LocalDate.now().toString();
        this.id = nextId;
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getDateJoined() {
        return dateJoined;
    }
}
