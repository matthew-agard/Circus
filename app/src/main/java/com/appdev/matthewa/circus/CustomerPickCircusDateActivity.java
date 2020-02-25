package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerPickCircusDateActivity extends AppCompatActivity {
    private CalendarView calendar;
    private String customerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Pick Circus Date");
        setContentView(R.layout.customer_pick_circus_date);

        customerUsername = getIntent().getStringExtra("Username");

        calendar = findViewById(R.id.pick_date);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                try {
                    String stringDate = (month + 1) + "-" + dayOfMonth + "-" + year;
                    DateFormat formattedDate = new SimpleDateFormat("MM-dd-yyyy");
                    Date date = formattedDate.parse(stringDate);
                    viewVotedActs(date.getTime());
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
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
