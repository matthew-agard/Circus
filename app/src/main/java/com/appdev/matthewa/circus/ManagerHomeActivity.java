package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ManagerHomeActivity extends AppCompatActivity {
    private ImageButton payroll, schedule, managePerformers, manageActs;
    private TextView payrollText, scheduleText, managePerformersText, manageActsText;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_home_page);

        payroll = findViewById(R.id.view_payroll);
        payroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPayroll();
            }
        });

        payrollText = findViewById(R.id.payroll_text);
        payrollText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPayroll();
            }
        });

        schedule = findViewById(R.id.view_schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSchedule();
            }
        });

        scheduleText = findViewById(R.id.schedule_text);
        scheduleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSchedule();
            }
        });

        managePerformers = findViewById(R.id.manage_performers);
        managePerformers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managePerformers();
            }
        });

        managePerformersText = findViewById(R.id.performers_text);
        managePerformersText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managePerformers();
            }
        });

        manageActs = findViewById(R.id.manage_circus_acts);
        manageActs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageActs();
            }
        });

        manageActsText = findViewById(R.id.circus_acts_text);
        manageActsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageActs();
            }
        });

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endUserSession();
            }
        });
    }

    private void viewPayroll() {
        Intent i = new Intent(ManagerHomeActivity.this, ManagerPayrollActivity.class);
        startActivity(i);
    }

    private void viewSchedule() {
        Intent i = new Intent(ManagerHomeActivity.this, ManagerScheduleActivity.class);
        startActivity(i);
    }

    private void managePerformers() {
        Intent i = new Intent(ManagerHomeActivity.this, ManagerPerformersActivity.class );
        startActivity(i);
    }

    private void manageActs() {
        Intent i = new Intent(ManagerHomeActivity.this, ManagerActsActivity.class);
        startActivity(i);
    }

    private void endUserSession() {
        Intent i = new Intent(ManagerHomeActivity.this, LoginActivity.class);
        startActivity(i);
    }
}