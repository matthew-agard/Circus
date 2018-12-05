package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface TicketPurchasesDAO {
    @Insert
    void insertPurchase(TicketPurchases...ticketPurchases);
}
