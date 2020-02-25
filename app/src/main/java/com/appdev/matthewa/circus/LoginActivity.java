package com.appdev.matthewa.circus;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private Button login;
    private TextView createAccount;
    private boolean validLogin;
    private CircusDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        setTitle("Login");

        db = CircusDatabase.getDatabase(this);
        
        email = findViewById(R.id.user_username);
        password = findViewById(R.id.user_password);

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomerLoginTask().execute(new Customer(email.getText().toString(), password.getText().toString()));
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
            else {
                validLogin = true;
            }

            return validLogin;
        }

        @Override
        protected void onPostExecute(Boolean validLogin) {
            if (validLogin) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                String customerUsername = email.getText().toString();
                email.getText().clear();
                password.getText().clear();
                Intent i = new Intent(LoginActivity.this, CustomerHomeActivity.class);
                i.putExtra("Username", customerUsername);
                startActivity(i);
            }
            else
                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

//    private class CreatePerformersTask extends AsyncTask<Employee, Void, Void> {
//        @Override
//        protected Void doInBackground(Employee... employees) {
//            for (Employee employee : employees) {
//                db.employeeDAO().insertEmployee(employee);
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            Toast.makeText(LoginActivity.this, "Performers instantiated", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private class CreateManagersTask extends AsyncTask<Employee, Void, Void> {
//        @Override
//        protected Void doInBackground(Employee... employees) {
//            for (Employee employee : employees) {
//                db.employeeDAO().insertEmployee(employee);
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            Toast.makeText(LoginActivity.this, "Managers instantiated", Toast.LENGTH_SHORT).show();
//        }
//    }

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
//        new CreateManagersTask().execute(new Employee("matthew@circus.org", "master", "Matthew", "Manager", null));
    }
}