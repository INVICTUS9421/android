package com.example.sampleapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registerpage extends AppCompatActivity {

    EditText name;
    EditText cpassword;
    EditText email;
    EditText password;
    Button button;
    DatabaseHelper databaseHelper;  // Database helper instance

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Initialize UI components
        TextView loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(v -> {
            Intent intent = new Intent(registerpage.this, loginpage.class);
            startActivity(intent);
        });

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        button = findViewById(R.id.loginbutton);

        // Register button click listener
        button.setOnClickListener(view -> {
            String n = name.getText().toString();
            String em = email.getText().toString();
            String cpass = cpassword.getText().toString();
            String pass = password.getText().toString();

            if (em.isEmpty() || pass.isEmpty() || n.isEmpty() || cpass.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                if (pass.equals(cpass)) {
                    if (isValid(pass)) {
                        // Add user to database
                        databaseHelper.addUser(em, pass);
                        Toast.makeText(getApplicationContext(), "Record Inserted!!!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(registerpage.this, loginpage.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Password must contain letters, digits, and special characters", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password and confirm password do not match!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to check if the password is valid
    public static boolean isValid(String pass) {
        int chkpt1 = 0, chkpt2 = 0, chkpt3 = 0;

        if (pass.length() < 8)
            return false;
        else {
            for (int p = 0; p < pass.length(); p++) {
                if (Character.isLetter(pass.charAt(p)))
                    chkpt1 = 1;
            }

            for (int p = 0; p < pass.length(); p++) {
                if (Character.isDigit(pass.charAt(p)))
                    chkpt2 = 1;
            }

            for (int p = 0; p < pass.length(); p++) {
                char c = pass.charAt(p);
                if ((c >= 33 && c <= 46) || c == 64)
                    chkpt3 = 1;
            }

            return chkpt1 == 1 && chkpt2 == 1 && chkpt3 == 1;
        }
    }
}
