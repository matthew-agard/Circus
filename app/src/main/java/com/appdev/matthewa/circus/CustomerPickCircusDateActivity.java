package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

public class CustomerPickCircusDateActivity extends AppCompatActivity {
    private CalendarView chosenDate;
    private String customerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Pick Circus Date");
        setContentView(R.layout.customer_pick_circus_date);

        customerUsername = getIntent().getStringExtra("Username");

        chosenDate = findViewById(R.id.pick_date);
        chosenDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                viewVotedActs(chosenDate.getDate());
            }
        });
    }

    private void viewVotedActs(long dateSelected) {
        Intent i = new Intent(CustomerPickCircusDateActivity.this, CustomerCircusDateDetailsActivity.class);
        i.putExtra("Date", dateSelected);
        i.putExtra("Username", customerUsername);
        startActivity(i);
    }

}
