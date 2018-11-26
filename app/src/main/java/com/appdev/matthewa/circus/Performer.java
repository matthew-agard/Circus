package com.appdev.matthewa.circus;

import java.util.UUID;

public class Performer {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private Act actAssignemt;

    public Performer() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Act getActAssignemt() {
        return actAssignemt;
    }

    public void setActAssignemt(Act actAssignemt) {
        this.actAssignemt = actAssignemt;
    }
}
