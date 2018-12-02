package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(primaryKeys = {"date", "customer"})
public class TicketPurchases {

    @NonNull private Date date;
    @NonNull private String customer;
    @NonNull private int numTickets;

    public TicketPurchases(@NonNull Date date, @NonNull String customer, @NonNull int numTickets) {
        this.date = date;
        this.customer = customer;
        this.numTickets = numTickets;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(@NonNull String customer) {
        this.customer = customer;
    }

    @NonNull
    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(@NonNull int numTickets) {
        this.numTickets = numTickets;
    }
}

