package com.appdev.matthewa.circus;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class CustomerCastVoteActivity extends AppCompatActivity {
    private ListView displayActs;
    private ActAdapter adapter;
    private String[] allActs;
    private ArrayList<String> votedActs;
    private int actsSelected = 0;
    private Button submitVote;
    private long customerDate;
    private CircusDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_cast_act_votes);
        setTitle("Cast Act Votes");

        customerDate = getIntent().getLongExtra("Date", 0);
        votedActs = new ArrayList<>();
        db = CircusDatabase.getDatabase(this);

        new RetrieveAllActs().execute();

        displayActs = findViewById(R.id.load_voted_acts);
        displayActs.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        displayActs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(actsSelected < 3) {
                    votedActs.add(parent.getItemAtPosition(position).toString());
                    view.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                    actsSelected++;
                }
            }
        });

        submitVote = findViewById(R.id.confirm_vote);
        submitVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actsSelected == 3) {
                    new CastVoteTask().execute(new Votes(DateConverter.toDate(customerDate), votedActs.get(0), 1),
                                                new Votes(DateConverter.toDate(customerDate), votedActs.get(1), 1),
                                                new Votes(DateConverter.toDate(customerDate), votedActs.get(2), 1));
                }
                else
                    Toast.makeText(CustomerCastVoteActivity.this, "You must cast exactly 3 votes", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class RetrieveAllActs extends AsyncTask<Void, Void, String[]> {
        @Override
        protected String[] doInBackground(Void... voids) {
            allActs =  db.employeeDAO().getAllActs();
            return allActs;
        }

        @Override
        protected void onPostExecute(String[] acts) {
            adapter = new ActAdapter(acts);
            displayActs.setAdapter(adapter);
        }
    }

    private class ActAdapter extends ArrayAdapter<String> {
        public ActAdapter(String[] acts) {
            super(CustomerCastVoteActivity.this, 0, acts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(null == convertView) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_acts, null);
            }

            String act = getItem(position);

            if (act != null) {
                TextView actName = convertView.findViewById(R.id.act_list_name);
                actName.setText(act);
            }

            return convertView;
        }
    }

    private class CastVoteTask extends AsyncTask<Votes, Void, Void> {
        @Override
        protected Void doInBackground(Votes... votes) {
            db.votesDAO().castInitialVote(votes);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(CustomerCastVoteActivity.this, "Your votes have been cast", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
