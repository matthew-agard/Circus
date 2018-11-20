package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CustomerHomeActivity extends AppCompatActivity {
    private ImageButton createCircusDay, reviewCircusDay;
    private TextView createCircusDayText, reviewCircusDayText;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_home_page);

        createCircusDay = findViewById(R.id.view_pay_stubs);
        createCircusDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitCircus();
            }
        });

        createCircusDayText = findViewById(R.id.pay_stubs_text);
        createCircusDayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitCircus();
            }
        });

        reviewCircusDay = findViewById(R.id.view_feedback);
        reviewCircusDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeReview();
            }
        });

        reviewCircusDayText = findViewById(R.id.feedback_text);
        reviewCircusDayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeReview();
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

    private void visitCircus() {
        Intent i = new Intent(CustomerHomeActivity.this, CustomerPickCircusDateActivity.class);
        startActivity(i);
    }

    private void writeReview() {
        Intent i = new Intent(CustomerHomeActivity.this, CustomerReviewActivity.class);
        startActivity(i);
    }

    private void endUserSession() {
        Intent i = new Intent(CustomerHomeActivity.this, );
        startActivity(i);
    }
}
