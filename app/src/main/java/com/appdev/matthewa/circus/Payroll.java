package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(primaryKeys = {"date", "act"})
public class Payroll {
    @NonNull private Date date;
    @NonNull private String act;
    @NonNull private int pay;

    public Payroll(@NonNull Date date, @NonNull String act, @NonNull int pay) {
        this.date = date;
        this.act = act;
        this.pay = pay;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
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
