package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Spinner userSpinner;
    private EditText email, password;
    private Button login;
    private TextView createAccount;
    private int userTypePosition = 0;
    private boolean validLogin;
    private CircusDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.determine_user);
        setTitle("Login");

        db = CircusDatabase.getDatabase(this);

        userSpinner = findViewById(R.id.user_type);
        final ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.user_type, android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(adapter);

        userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userTypePosition = position;
                verifyAccountCreation(userTypePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                verifyAccountCreation(0);
            }
        });

        email = findViewById(R.id.user_username);
        email.addTextChangedListener(new TextWatcher() {
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

        password = findViewById(R.id.user_password);
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

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser(email.getText().toString(), password.getText().toString());
            }
        });

        createAccount = findViewById(R.id.create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserAccount();
            }
        });
    }

    private class CustomerLoginTask extends AsyncTask<Customer, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Customer... customers) {
            Customer user = db.customerDAO().findCustomerLogin(customers[0].getUsername(), customers[0].getPassword());

            if(user == null)
                validLogin = false;
            else
                validLogin = true;

            return validLogin;
        }

        @Override
        protected void onPostExecute(Boolean validLogin) {
            if (validLogin) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                email.getText().clear();
                password.getText().clear();
                Intent i = new Intent(LoginActivity.this, CustomerHomeActivity.class);
                startActivity(i);
            }
            else
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    private class PerformerLoginTask extends AsyncTask<Employee, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Employee... employees) {
            Employee user = db.employeeDAO().findPerformerLogin(employees[0].getEmail(), employees[0].getPassword());

            if(user == null)
                validLogin = false;
            else
                validLogin = true;

            return validLogin;
        }

        @Override
        protected void onPostExecute(Boolean validLogin) {
            if (validLogin) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                email.getText().clear();
                password.getText().clear();
                Intent i = new Intent(LoginActivity.this, PerformerHomeActivity.class);
                startActivity(i);
            }
            else
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    private class ManagerLoginTask extends AsyncTask<Employee, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Employee... employees) {
            Employee user = db.employeeDAO().findManagerLogin(employees[0].getEmail(), employees[0].getPassword());

            if(user == null)
                validLogin = false;
            else
                validLogin = true;

            return validLogin;
        }

        @Override
        protected void onPostExecute(Boolean validLogin) {
            if (validLogin) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                email.getText().clear();
                password.getText().clear();
                Intent i = new Intent(LoginActivity.this, ManagerHomeActivity.class);
                startActivity(i);
            }
            else
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void createUserAccount() {
        email.getText().clear();
        password.getText().clear();
        Intent i = new Intent(LoginActivity.this, CustomerCreateAccountActivity.class);
        startActivity(i);
//        new CreatePerformersTask().execute(new Employee("daniel@circus.org", "animals1", "Daniel", "Performer", "Animals"),
//                                            new Employee("nathan@circus.org", "clowns1", "Nathan", "Performer", "Clowns"),
//                                            new Employee("greg@circus.org", "juggles1", "Greg", "Performer", "Juggling"),
//                                            new Employee("alexis@circus.org", "stilts1", "Alexis", "Performer", "Stilts"),
//                                            new Employee("kayla@circus.org", "tightrope1", "Kayla", "Performer", "Tightrope"),
//                                            new Employee("bobby@circus.org", "trapeze1", "Bobby", "Performer", "Trapeze"),
//                                            new Employee("ashley@circus.org", "unicycle1", "Ashley", "Performer", "Unicycle"));
//        new CreateManagersTask().execute(new Employee("matthew@circus.org", "master", "Matthew Agard", "Manager", null),
//                                            new Employee("min@circus.org", "master", "Min Seung", "Manager", null));
    }

    private void verifyAccountCreation(int userTypePosition) {
        if(userTypePosition == 0) {
            createAccount.setVisibility(View.VISIBLE);
            createAccount.setClickable(true);
        }

        else {
            createAccount.setVisibility(View.INVISIBLE);
            createAccount.setClickable(false);
        }
    }

    private void signInUser(String email, String password) {
        if(userTypePosition == 0)
            new CustomerLoginTask().execute(new Customer(email, password));

        else if (userTypePosition == 1)
            new PerformerLoginTask().execute(new Employee(email, password));

        else
            new ManagerLoginTask().execute(new Employee(email, password));
    }
}