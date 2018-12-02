package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"act"})
public class Act {
    @NonNull private String act;

    public Act(@NonNull String act) {
        this.act = act;
    }

    public String getAct() {
        return act;
    }

    public void setAct(@NonNull String act) {
        this.act = act;
    }
}



