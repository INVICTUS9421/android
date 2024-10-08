package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {

    EditText email;
    EditText password;
    Button button;
    DatabaseHelper databaseHelper;  // Database helper instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Initialize UI components
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.loginbutton);

        // Navigate to register page if the user clicks the registration link
        TextView registerTextView = findViewById(R.id.registerTextView);
        registerTextView.setClickable(true);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this, registerpage.class);
                startActivity(intent);
            }
        });

        // Login button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pass = password.getText().toString();

                // Check if fields are empty
                if (em.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(loginpage.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Validate user credentials with the database
                    boolean isValid = databaseHelper.checkUser(em, pass);

                    if (isValid) {
                        Toast.makeText(loginpage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        // Navigate to the homepage
                        Intent intent = new Intent(loginpage.this, HomePage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(loginpage.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
