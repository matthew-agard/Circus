package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class CustomerCircusDateDetailsActivity extends AppCompatActivity {
    private RecyclerView loadActs;
    private Button castVote, purchaseTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_circus_date_details);

        loadActs = findViewById(R.id.load_voted_acts);

        castVote = findViewById(R.id.cast_vote);
        castVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                castVotes();
            }
        });

        purchaseTicket = findViewById(R.id.make_purchase);
        purchaseTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseTickets();
            }
        });

    }

    private void castVotes() {
        Intent i = new Intent(CustomerCircusDateDetailsActivity.this, CustomerCastVoteActivity.class);
        startActivity(i);
    }

    private void purchaseTickets() {
        Intent i = new Intent(CustomerCircusDateDetailsActivity.this, CustomerPurchaseTicketActivity.class);
        startActivity(i);
    }
}
