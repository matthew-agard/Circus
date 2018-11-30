package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;

public class CustomerReviewActivity extends AppCompatActivity {
    private Spinner attendanceDate, actType;
    private EditText userReview;
    private Button submitReview;

    private class DateAdapter extends ArrayAdapter<Date> {
        public DateAdapter(ArrayList<Date> dates) {
            super(CustomerReviewActivity.this, 0, dates);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_date, null);
            }

            Date date = getItem(position);

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Event Review");
        setContentView(R.layout.customer_acts_feedback);

        attendanceDate = findViewById(R.id.choose_attendance_date);

        actType = findViewById(R.id.choose_act);

        userReview = findViewById(R.id.user_review);
        userReview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        submitReview = findViewById(R.id.submit_review);
        submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
