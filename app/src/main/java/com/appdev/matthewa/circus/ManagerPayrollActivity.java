package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Spinner;

public class ManagerPayrollActivity extends AppCompatActivity {
    private Spinner actChosen;
    private RecyclerView payrollStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_revenue_view);
        setTitle("Act Payroll");
    }
}
