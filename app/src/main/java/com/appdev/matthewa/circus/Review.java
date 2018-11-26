package com.appdev.matthewa.circus;

import java.util.Date;
import java.util.UUID;

public class Review {
    private UUID id;
    private Date attendanceDate;
    private Act actName;
    private String reviewText;

    public Review() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Act getActName() {
        return actName;
    }

    public void setActName(Act actName) {
        this.actName = actName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
