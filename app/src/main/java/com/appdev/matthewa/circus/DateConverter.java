package com.appdev.matthewa.circus;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Long fromDate(Date date) {
        if (date==null) {
            return(null);
        }

        return(date.getTime());
    }

    @TypeConverter
    public static Date toDate(Long millisecs) {
        if (millisecs==null) {
            return(null);
        }

        return(new Date(millisecs));
    }
}
