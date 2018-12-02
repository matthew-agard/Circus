package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(primaryKeys = {"customer", "attendanceDate", "act"})
public class Review {
    @NonNull private String customer;
    @NonNull private Date attendanceDate;
    @NonNull private String act;
    @NonNull private String review;

    public Review(@NonNull String customer, @NonNull Date attendanceDate, @NonNull String act, @NonNull String review) {
        this.customer = customer;
        this.attendanceDate = attendanceDate;
        this.act = act;
        this.review = review;
    }

    @NonNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(@NonNull String customer) {
        this.customer = customer;
    }

    @NonNull
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(@NonNull Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @NonNull
    public String getAct() {
        return act;
    }

    public void setAct(@NonNull String act) {
        this.act = act;
    }

    @NonNull
    public String getReview() {
        return review;
    }

    public void setReview(@NonNull String review) {
        this.review = review;
    }
}
