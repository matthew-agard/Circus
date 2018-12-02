package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

public class ManagerScheduleActivity extends FragmentActivity {
    private Spinner actChosen;
    private RecyclerView payrollStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_calendar_view);
        setTitle("Schedule View");
    }
}
