package com.appdev.matthewa.circus;

import java.util.ArrayList;
import java.util.UUID;

public class Act {
    private UUID id;
    private String actName;
    private ArrayList<Performer> actPerformers;

    public Act() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public ArrayList<Performer> getActPerformers() {
        return actPerformers;
    }

    public void setActPerformers(ArrayList<Performer> actPerformers) {
        this.actPerformers = actPerformers;
    }
}
