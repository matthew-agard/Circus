package com.appdev.matthewa.circus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CustomerCreateAccountActivity extends AppCompatActivity {
    private static final String TAG = "CustomerCreateAccount";
    private EditText email, password, confirmPassword;
    private String sEmail, sPassword, sConfirm;
    private Button createAccount;
    private FirebaseAuth mAuth;
    private boolean verified = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_create_account);
        setTitle("Create Account");

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.username);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sEmail = s.toString().trim();
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
                sPassword = s.toString().trim();
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
                sConfirm = s.toString().trim();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        createAccount = findViewById(R.id.create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sPassword.equals(sConfirm)) {
                    boolean success = createAccount(sEmail, sPassword);
                    if (success) {
                        email.getText().clear();
                        password.getText().clear();
                        confirmPassword.getText().clear();
                    }
                }

                else
                    Toast.makeText(CustomerCreateAccountActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private boolean createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(CustomerCreateAccountActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            verified = true;
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CustomerCreateAccountActivity.this, "Account not created successfully", Toast.LENGTH_SHORT).show();
                            verified = false;
                        }
                    }
                });

        return verified;
    }
}
