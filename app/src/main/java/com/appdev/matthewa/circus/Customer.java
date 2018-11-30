package com.appdev.matthewa.circus;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"email", "password"})
public class Customer {
    @NonNull private String email;
    @NonNull private String password;

    public Customer(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

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
}
