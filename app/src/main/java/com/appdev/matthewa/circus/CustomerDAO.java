package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface CustomerDAO {
    @Query("SELECT * FROM Customer WHERE username = :username AND password = :password")
    Customer findCustomerLogin(String username, String password);

    @Insert
    void insertCustomer(Customer... customers);
}
