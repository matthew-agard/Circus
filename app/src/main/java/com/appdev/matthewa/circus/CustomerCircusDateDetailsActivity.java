package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class CustomerCircusDateDetailsActivity extends AppCompatActivity {
    private ListView loadActs;
    private ActAdapter adapter;
    private Button castVote, purchaseTicket;
    private long customerDate;
    private String customerUsername;
    private Votes[] topActs;
    private CircusDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_circus_date_details);

        db = CircusDatabase.getDatabase(this);

        customerDate = getIntent().getLongExtra("Date", 0);
        customerUsername = getIntent().getStringExtra("Username");

        loadActs = findViewById(R.id.load_voted_acts);

        new RetrieveTopActs().execute(DateConverter.toDate(customerDate));

        castVote = findViewById(R.id.cast_vote);
        castVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                castVotes();
            }
        });

        purchaseTicket = findViewById(R.id.buy_ticket);
        purchaseTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseTickets();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        new RetrieveTopActs().execute(DateConverter.toDate(customerDate));
    }

    private class RetrieveTopActs extends AsyncTask<Date, Void, Votes[]> {
        @Override
        protected Votes[] doInBackground(Date... dates) {
            topActs = db.votesDAO().getTopActs(DateConverter.toDate(customerDate));
            return topActs;
        }

        @Override
        protected void onPostExecute(Votes[] topVotes) {
            if(topVotes.length > 0) {
                adapter = new ActAdapter(topVotes);
                loadActs.setAdapter(adapter);
            }
            else {
                Toast.makeText(CustomerCircusDateDetailsActivity.this, "No votes have been cast for this date", Toast.LENGTH_LONG).show();
            }
        }
    }

    private class ActAdapter extends ArrayAdapter<Votes> {
        public ActAdapter(Votes[] votes) {
            super(CustomerCircusDateDetailsActivity.this, 0, votes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(null == convertView) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_top_acts, null);
            }

            Votes votedAct = getItem(position);

            TextView actName = convertView.findViewById(R.id.act_list_name);
            actName.setText(votedAct.getAct());

//            TextView numVotes = convertView.findViewById(R.id.act_list_num_votes);
//            numVotes.setText(votedAct.getVotes());

            return convertView;
        }
    }

    private void castVotes() {
        Intent i = new Intent(CustomerCircusDateDetailsActivity.this, CustomerCastVoteActivity.class);
        i.putExtra("Date", customerDate);
        startActivity(i);
    }

    private void purchaseTickets() {
        Intent i = new Intent(CustomerCircusDateDetailsActivity.this, CustomerPurchaseTicketActivity.class);
        i.putExtra("Date", customerDate);
        i.putExtra("Username", customerUsername);
        startActivity(i);
    }
}