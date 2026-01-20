package com.example.meetingroom.model;

public class User {

    private Long id;
    private String name;

    public User(Long id, String name, String role) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}