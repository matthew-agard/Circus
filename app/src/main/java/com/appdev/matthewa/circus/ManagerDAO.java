package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface ManagerDAO {
    @Query("SELECT * FROM Manager WHERE email = :email AND password = :password")
    Customer findManagerLogin(String email, String password);

    @Insert
    void insertManager(Manager... managers);
}
