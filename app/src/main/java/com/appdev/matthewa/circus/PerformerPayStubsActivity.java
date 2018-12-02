package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class PerformerPayStubsActivity extends AppCompatActivity {
    private static final String TAG = "PerformerPayStubsActivity";
    private RecyclerView displayPayStubs;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList mPayStubs;

    private class PayStubAdapter extends ArrayAdapter {
        public PayStubAdapter(ArrayList payStubs) {
            super(PerformerPayStubsActivity.this, android.R.layout.activity_list_item, payStubs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_pay_stub, null);
            }

            TextView actName = convertView.findViewById(R.id.act_performed);
            TextView datePerformed = convertView.findViewById(R.id.date_performed);

            TextView payAmount = convertView.findViewById(R.id.payroll_earned);

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performer_pay_stubs);
        setTitle("Pay Stubs");

//        displayPayStubs = findViewById(R.id.view_stubs);
//        displayPayStubs.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        displayPayStubs.setLayoutManager(mLayoutManager);

    }
}
