package com.appdev.matthewa.circus;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {Customer.class, Employee.class, TicketPurchases.class, Votes.class}, version = 4)
@TypeConverters({DateConverter.class})
public abstract class CircusDatabase extends RoomDatabase {

    private static CircusDatabase INSTANCE;
    public abstract CustomerDAO customerDAO();
    public abstract EmployeeDAO employeeDAO();
    public abstract TicketPurchasesDAO ticketPurchasesDAO();
    public abstract VotesDAO votesDAO();

    static CircusDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (CircusDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CircusDatabase.class,
                            "Circus-Database").fallbackToDestructiveMigration().build();
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