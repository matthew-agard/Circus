package com.appdev.matthewa.circus;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CustomerPurchaseTicketActivity extends AppCompatActivity {
    private Spinner numTickets;
    private Button makePurchase;
    private int storeTotal = 1;
    private long customerDate;
    private String customerUsername;
    private CircusDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_purchase_ticket);
        setTitle("Purchase Tickets");

        db = CircusDatabase.getDatabase(this);

        customerDate = getIntent().getLongExtra("Date", 0);
        customerUsername = getIntent().getStringExtra("Username");

        numTickets = findViewById(R.id.num_tickets);
        final ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.ticket_selection, android.R.layout.simple_spinner_dropdown_item);
        numTickets.setAdapter(adapter);

        numTickets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                storeTotal = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        makePurchase = findViewById(R.id.make_purchase);
        makePurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PurchaseTickets().execute(new TicketPurchases(DateConverter.toDate(customerDate), customerUsername, storeTotal));
                finish();
            }
        });
    }

    private class PurchaseTickets extends AsyncTask<TicketPurchases, Void, Void> {
        @Override
        protected Void doInBackground(TicketPurchases... ticketPurchases) {
            db.ticketPurchasesDAO().insertPurchase(ticketPurchases[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(CustomerPurchaseTicketActivity.this, "Transaction completed", Toast.LENGTH_SHORT).show();
        }
    }
}
