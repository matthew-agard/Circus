package com.appdev.matthewa.circus;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Act.class, Customer.class, Manager.class, Payroll.class, Performer.class,
                        Revenue.class, Review.class, Schedule.class, Votes.class}, version = 1)
public abstract class CircusDatabase extends RoomDatabase {

    private static CircusDatabase INSTANCE;
    public abstract ActDAO actDAO();
    public abstract CustomerDAO customerDAO();
    public abstract ManagerDAO managerDAO();
    public abstract PayrollDAO payrollDAO();
    public abstract PerformerDAO performerDAO();
    public abstract RevenueDAO revenueDAO();
    public abstract ReviewDAO reviewDAO();
    public abstract ScheduleDAO scheduleDAO();
    public abstract VotesDAO votesDAO();

    static CircusDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (CircusDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CircusDatabase.class, "Circus-Database").build();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public void clearAllTables() {
        // Not utilized
    }
}
