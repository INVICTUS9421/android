package com.example.sampleapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView pkgname, details, totalcost ;
    Button bookAppointment, back ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labtestdetails);

        pkgname = findViewById(R.id.carttitle);
        details = findViewById(R.id.details);
        totalcost = findViewById(R.id.totalcost);
        back = findViewById(R.id.back);
        bookAppointment = findViewById(R.id.bookAppointment);

        Intent intent = getIntent();
        pkgname.setText(intent.getStringExtra("text1"));
        details.setText(intent.getStringExtra("text2"));
        totalcost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });
        bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}