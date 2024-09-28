package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class FindDoctorActivity extends AppCompatActivity {

    private List<String> cardiologistList = new ArrayList<>();
    private List<String> dentistList = new ArrayList<>();
    private List<String> surgeonList = new ArrayList<>();
    private List<String> physicianList = new ArrayList<>();
    private List<String> pulmonologistList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finddoc);

        // Initialize the lists of doctors
        cardiologistList.add("Dr. John Smith");
        cardiologistList.add("Dr. Jane Doe");
        cardiologistList.add("Dr. Bob Johnson");

        dentistList.add("Dr. Mike Brown");
        dentistList.add("Dr. Emily Chen");
        dentistList.add("Dr. David Lee");

        surgeonList.add("Dr. Sarah Taylor");
        surgeonList.add("Dr. Kevin White");
        surgeonList.add("Dr. Olivia Martin");

        physicianList.add("Dr. Michael Davis");
        physicianList.add("Dr. Sophia Patel");
        physicianList.add("Dr. William Hall");

        pulmonologistList.add("Dr. James Wilson");
        pulmonologistList.add("Dr. Laura Garcia");
        pulmonologistList.add("Dr. Daniel Kim");

        CardView cardiologistCard = findViewById(R.id.cardiologistCard);
        cardiologistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, finddoc.class);
                intent.putStringArrayListExtra("doctorList", (ArrayList<String>) cardiologistList);
                startActivity(intent);
            }
        });

        CardView dentistCard = findViewById(R.id.dentistCard);
        dentistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, finddoc.class);
                intent.putStringArrayListExtra("doctorList", (ArrayList<String>) dentistList);
                startActivity(intent);
            }
        });

        CardView surgeonCard = findViewById(R.id.surgeonCard);
        surgeonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, finddoc.class);
                intent.putStringArrayListExtra("doctorList", (ArrayList<String>) surgeonList);
                startActivity(intent);
            }
        });

        CardView physicianCard = findViewById(R.id.physicianCard);
        physicianCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, finddoc.class);
                intent.putStringArrayListExtra("doctorList", (ArrayList<String>) physicianList);
                startActivity(intent);
            }
        });

        CardView pulmonologistCard = findViewById(R.id.pulmonologistCard);
        pulmonologistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, finddoc.class);
                intent.putStringArrayListExtra("doctorList", (ArrayList<String>) pulmonologistList);
                startActivity(intent);
            }
        });

        CardView back = findViewById(R.id.backToHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });

        // Get the OnBackPressedDispatcher
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();

        // Create a new OnBackPressedCallback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button press here
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        };

        // Add the callback to the OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, callback);
    }
}