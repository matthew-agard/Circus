package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"date"})
public class Revenue {

    @NonNull private String date;
    @NonNull private int revenue;

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(@NonNull int revenue) {
        this.revenue = revenue;
    }
}
