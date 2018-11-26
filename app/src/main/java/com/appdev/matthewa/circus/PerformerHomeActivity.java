package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PerformerHomeActivity extends AppCompatActivity {
    private ImageButton payStubs, schedule, customerReviews;
    private TextView payStubsText, scheduleText, customerReviewsText;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performer_home_page);

        payStubs = findViewById(R.id.view_pay_stubs);
        payStubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPayStubs();
            }
        });

        payStubsText = findViewById(R.id.pay_stubs_text);
        payStubsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPayStubs();
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

        customerReviews = findViewById(R.id.view_feedback);
        customerReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewCustomerReviews();
            }
        });

        customerReviewsText = findViewById(R.id.feedback_text);
        customerReviewsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewCustomerReviews();
            }
        });

//        logout = findViewById(R.id.logout);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                endUserSession();
//            }
//        });
    }

    private void viewPayStubs() {
        Intent i = new Intent(PerformerHomeActivity.this, PerformerPayStubsActivity.class);
        startActivity(i);
    }

    private void viewSchedule() {
        Intent i = new Intent(PerformerHomeActivity.this, PerformerScheduleActivity.class);
        startActivity(i);
    }

    private void viewCustomerReviews() {
        Intent i = new Intent(PerformerHomeActivity.this, PerformerReviewActivity.class);
        startActivity(i);
    }

//    private void endUserSession() {
//        Intent i = new Intent(PerformerHomeActivity.this, );
//        startActivity(i);
//    }
}
