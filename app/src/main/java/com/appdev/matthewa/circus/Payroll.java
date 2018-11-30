package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"date"})
public class Payroll {
    @NonNull private String date;
    @NonNull private String act;
    @NonNull private int pay;

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getAct() {
        return act;
    }

    public void setAct(@NonNull String act) {
        this.act = act;
    }

    @NonNull
    public int getPay() {
        return pay;
    }

    public void setPay(@NonNull int pay) {
        this.pay = pay;
    }
}
