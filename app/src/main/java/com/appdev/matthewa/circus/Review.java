package com.appdev.matthewa.circus;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Reviews")
public class Review {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "customer")
    private String customerEmail;

    @ColumnInfo(name = "date")
    private String attendanceDate;

    @ColumnInfo(name = "act")
    private String actName;

    @ColumnInfo(name = "review")
    private String reviewText;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
