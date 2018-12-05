package com.appdev.matthewa.circus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.Date;

@Dao
public interface VotesDAO {
    @Query("SELECT * FROM Votes WHERE date = :customerDate ORDER BY votes DESC LIMIT 3")
    Votes[] getTopActs(Date customerDate);

    @Query("SELECT * FROM Votes WHERE date = :customerDate")
    Votes[] isAlreadyVoted(Date customerDate);

    @Insert
    void castInitialVote(Votes... votes);

    @Update
    void incrementVote(Votes... votes);
}
