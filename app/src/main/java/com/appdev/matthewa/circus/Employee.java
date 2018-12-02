package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"email"})
public class Employee {

    @NonNull private String email;
    @NonNull private String password;
    @NonNull private String name;
    @NonNull private String employeeType;
    private String act;

    public Employee(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

//    public Employee(@NonNull String email, @NonNull String password, @NonNull String name, @NonNull String employeeType, String act) {
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.employeeType = employeeType;
//        this.act = act;
//    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(@NonNull String employeeType) {
        this.employeeType = employeeType;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}
