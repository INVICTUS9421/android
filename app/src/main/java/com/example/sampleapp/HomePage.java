package com.example.sampleapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // LAB TEST CardView
        CardView labTestCard = findViewById(R.id.labTestCard);
        labTestCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, LabTestActivity.class);
                startActivity(intent);
            }
        });

        // BUY MEDICINE CardView
        CardView buyMedicineCard = findViewById(R.id.buyMedicineCard);
        buyMedicineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, BuyMedicineActivity.class);
                startActivity(intent);
            }
        });

        // FIND DOCTOR CardView
        CardView findDoctorCard = findViewById(R.id.findDoctorCard);
        findDoctorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, finddoc.class);
                startActivity(intent);
            }
        });

        // ARTICLES CardView
        CardView articlesCard = findViewById(R.id.articlesCard);
        articlesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ArticlesActivity.class);
                startActivity(intent);
            }
        });

        // ORDER DETAILS CardView
        CardView orderDetailsCard = findViewById(R.id.orderDetailsCard);
        orderDetailsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View    view) {
                Intent intent = new Intent(HomePage.this, OrderDetailsActivity.class);
                startActivity(intent);
            }
        });

        // LOGOUT CardView
        CardView exit = findViewById(R.id.exitHome);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                builder.setMessage("Are you sure you want to logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(HomePage.this, loginpage.class));
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }
}