package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CustomerHomeActivity extends AppCompatActivity {
    private ImageButton createCircusDay;
    private TextView createCircusDayText;
    private Button logout;
    private String customerUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Customer Home Page");
        setContentView(R.layout.customer_home_page);

        customerUsername = getIntent().getStringExtra("Username");

        createCircusDay = findViewById(R.id.circus_day_pic);
        createCircusDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitCircus();
            }
        });

        createCircusDayText = findViewById(R.id.circus_day_text);
        createCircusDayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitCircus();
            }
        });

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void visitCircus() {
        Intent i = new Intent(CustomerHomeActivity.this, CustomerPickCircusDateActivity.class);
        i.putExtra("Username", customerUsername);
        startActivity(i);
    }
}
