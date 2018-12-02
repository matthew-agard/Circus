package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import java.util.Date;


@Entity(primaryKeys = {"date", "act"})
public class Votes {

    @NonNull private Date date;
    @NonNull private String act;
    @NonNull private int votes;

    public Votes(@NonNull Date date, @NonNull String act, @NonNull int votes) {
        this.date = date;
        this.act = act;
        this.votes = votes;
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
    public int getVotes() {
        return votes;
    }

    public void setVotes(@NonNull int votes) {
        this.votes = votes;
    }
}
