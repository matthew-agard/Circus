package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PerformerFeedbackActivity extends FragmentActivity {
    private static final String TAG = "PerformerFeedbackActivity";
    private RecyclerView displayReviews;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Review> mReviews;

    private class ReviewAdapter extends ArrayAdapter {
        public ReviewAdapter(ArrayList<Review> reviews) {
            super(PerformerFeedbackActivity.this, android.R.layout.activity_list_item, reviews);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_review, null);
            }

            TextView customerName = convertView.findViewById(R.id.customer_username);
            TextView reviewWritten = convertView.findViewById(R.id.customer_review);

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performer_pay_stubs);
        setTitle("View Feedback");
//
//        displayReviews = findViewById(R.id.choose_review);
//        displayReviews.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        displayReviews.setLayoutManager(mLayoutManager);

    }
}
