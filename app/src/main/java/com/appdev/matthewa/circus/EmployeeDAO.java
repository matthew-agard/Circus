package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface EmployeeDAO {
    @Query("SELECT DISTINCT act FROM Employee")
    String[] getAllActs();

    @Insert
    void insertEmployee(Employee... employees);

    @Delete
    void deletePerformer(Employee... employees);
}
