package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

public class PerformerScheduleActivity extends AppCompatActivity {
    private CalendarView performanceCalednar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performer_schedule_view);
        setTitle("View Schedule");

        performanceCalednar = findViewById(R.id.schedule_performer);
    }
}
