package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface PerformerDAO {
    @Query("SELECT * FROM Performer WHERE email = :email AND password = :password")
    Customer findPerformerLogin(String email, String password);

    @Insert
    void insertPerformer(Performer... performers);
}
