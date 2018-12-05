package com.appdev.matthewa.circus;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerCreateAccountActivity extends AppCompatActivity {
    private EditText username, password, confirmPassword;
    private Button createAccount;
    private CircusDatabase db;

    private class CreateCustomerTask extends AsyncTask<Customer, Void, Void> {
        @Override
        protected Void doInBackground(Customer... customers) {
            db.customerDAO().insertCustomer(customers[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(CustomerCreateAccountActivity.this, "Account created", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_create_account);
        setTitle("Create Account");

        db = CircusDatabase.getDatabase(this);

        username = findViewById(R.id.username);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password = findViewById(R.id.password);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmPassword = findViewById(R.id.password_reenter);
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        createAccount = findViewById(R.id.create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                    createAccount(username.getText().toString(), password.getText().toString());
                }

                else
                    Toast.makeText(CustomerCreateAccountActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createAccount(String userEmail, String userPassword) {
        new CreateCustomerTask().execute(new Customer(userEmail, userPassword));
        username.getText().clear();
        password.getText().clear();
        confirmPassword.getText().clear();
        finish();
    }
}
