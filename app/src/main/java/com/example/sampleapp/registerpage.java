package com.example.sampleapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);

        TextView loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registerpage.this, loginpage.class);
                startActivity(intent);
            }
        });

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        button = findViewById(R.id.loginbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String em = email.getText().toString();
                String cpass = cpassword.getText().toString();
                String pass = password.getText().toString();
                if (em.isEmpty() || pass.isEmpty()||n.isEmpty()||cpass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (pass.compareTo(cpass)==0)
                    {
                        if (isValid(pass))
                        {
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(registerpage.this,loginpage.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Password must contain atleast 8 characters,having letter digit ans special characters", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password and confirm password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String password)
    {
        int case1=0,case2=0,case3=0;
        if(password.length()<8)
        {
            return false;
        }
        else
        {
            for (int i=0;i<password.length();i++)
            {
                if (Character.isDigit(password.charAt(i)))
                    case1 = 1;
            }
            for (int i=0;i<password.length();i++)
            {
                if (Character.isAlphabetic(password.charAt(i)))
                    case2 = 1;
            }
            for (int i=0;i<password.length();i++)
            {
                char c = password.charAt(i);
                if (c>=33 && c<=46 || c==64)
                    case3=1;
            }
            return case1 == 1 && case2 == 1 && case3 == 1;
        }
    }
}
