package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"act"})
public class Act {

    @NonNull private String act;

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}



