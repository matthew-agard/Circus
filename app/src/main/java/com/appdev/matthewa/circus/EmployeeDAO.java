package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface EmployeeDAO {
    @Query("SELECT * FROM Employee WHERE employeeType = 'Performer' AND email = :email AND password = :password")
    Employee findPerformerLogin(String email, String password);

    @Query("SELECT * FROM Employee WHERE employeeType = 'Manager' AND email = :email AND password = :password")
    Employee findManagerLogin(String email, String password);

    @Insert
    void insertPerformer(Employee... employees);

    @Insert
    void insertManager(Employee... employees);

    @Delete
    void deletePerformer(Employee... employees);
}
