package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class finddoc extends AppCompatActivity {

    private List<String> cardiologistList = new ArrayList<>();
    private List<String> dentistList = new ArrayList<>();
    private List<String> surgeonList = new ArrayList<>();
    private List<String> physicianList = new ArrayList<>();
    private List<String> pulmonologistList = new ArrayList<>();

    private final String[][] cardiologist_details = {
            {"Doctor Name : Dr. Rajesh Gupta", "Hospital Address : Pune", "Exp : 12yrs", "Mobile No: 7898998998", "1500"},
            {"Doctor Name : Dr. Sneha Sharma", "Hospital Address : Mumbai", "Exp : 10yrs", "Mobile No: 7798998999", "1800"},
            {"Doctor Name : Dr. Arun Mehta", "Hospital Address : Pimpri", "Exp : 8yrs", "Mobile No: 8898998998", "1300"},
            {"Doctor Name : Dr. Kavita Jain", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7898998997", "1400"}
    };

    // Dentist Data
    private final String[][] dentist_details = {
            {"Doctor Name : Dr. Neha Deshmukh", "Hospital Address : Nigdi", "Exp : 6yrs", "Mobile No: 7898098098", "600"},
            {"Doctor Name : Dr. Rakesh Pawar", "Hospital Address : Pune", "Exp : 9yrs", "Mobile No: 8898998999", "800"},
            {"Doctor Name : Dr. Anjali Kulkarni", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9798998997", "500"},
            {"Doctor Name : Dr. Vikrant Gaikwad", "Hospital Address : Chinchwad", "Exp : 7yrs", "Mobile No: 9798098098", "700"}
    };

    // Surgeon Data
    private final String[][] surgeon_details = {
            {"Doctor Name : Dr. Alok Verma", "Hospital Address : Katraj", "Exp : 10yrs", "Mobile No: 8898098098", "2000"},
            {"Doctor Name : Dr. Ritu Desai", "Hospital Address : Pune", "Exp : 12yrs", "Mobile No: 7898998098", "2500"},
            {"Doctor Name : Dr. Ravi Pandey", "Hospital Address : Nigdi", "Exp : 8yrs", "Mobile No: 8898998099", "1800"},
            {"Doctor Name : Dr. Suman Mishra", "Hospital Address : Pimpri", "Exp : 6yrs", "Mobile No: 7798998097", "1600"}
    };

    // Physician Data
    private final String[][] physician_details = {
            {"Doctor Name : Dr. Kiran Joshi", "Hospital Address : Chinchwad", "Exp : 9yrs", "Mobile No: 9798998097", "1200"},
            {"Doctor Name : Dr. Anil Sharma", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No: 8798998098", "1500"},
            {"Doctor Name : Dr. Swati Verma", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798998098", "1100"},
            {"Doctor Name : Dr. Parag Kulkarni", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 7898998099", "1000"}
    };

    // Pulmonologist Data
    private final String[][] pulmonologist_details = {
            {"Doctor Name : Dr. Prashant Singh", "Hospital Address : Pune", "Exp : 11yrs", "Mobile No: 7898998996", "1300"},
            {"Doctor Name : Dr. Aarti Nair", "Hospital Address : Chinchwad", "Exp : 9yrs", "Mobile No: 8898998995", "1200"},
            {"Doctor Name : Dr. Ravi Patel", "Hospital Address : Nigdi", "Exp : 8yrs", "Mobile No: 7898998994", "1100"},
            {"Doctor Name : Dr. Suresh Kumar", "Hospital Address : Katraj", "Exp : 6yrs", "Mobile No: 7898998993", "1000"}
    };

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
                Intent intent = new Intent(finddoc.this, DoctorDetails.class);
                ArrayList<String> doctorList = new ArrayList<>();
                for (String[] details : cardiologist_details) {
                    for (String detail : details) {
                        doctorList.add(detail);
                    }
                }
                intent.putStringArrayListExtra("doctorList", doctorList);
                startActivity(intent);
            }
        });

        CardView dentistCard = findViewById(R.id.dentistCard);
        dentistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(finddoc.this, DoctorDetails.class);
                ArrayList<String> doctorList = new ArrayList<>();
                for (String[] details : dentist_details) {
                    for (String detail : details) {
                        doctorList.add(detail);
                    }
                }
                intent.putStringArrayListExtra("doctorList", doctorList);
                startActivity(intent);
            }
        });

        CardView surgeonCard = findViewById(R.id.surgeonCard);
        surgeonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(finddoc.this, DoctorDetails.class);
                ArrayList<String> doctorList = new ArrayList<>();
                for (String[] details : surgeon_details) {
                    for (String detail : details) {
                        doctorList.add(detail);
                    }
                }
                intent.putStringArrayListExtra("doctorList", doctorList);
                startActivity(intent);
            }
        });

        CardView physicianCard = findViewById(R.id.physicianCard);
        physicianCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(finddoc.this, DoctorDetails.class);
                ArrayList<String> doctorList = new ArrayList<>();
                for (String[] details : physician_details) {
                    for (String detail : details) {
                        doctorList.add(detail);
                    }
                }
                intent.putStringArrayListExtra("doctorList", doctorList);
                startActivity(intent);
            }
        });

        CardView pulmonologistCard = findViewById(R.id.pulmonologistCard);
        pulmonologistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(finddoc.this, DoctorDetails.class);
                ArrayList<String> doctorList = new ArrayList<>();
                for (String[] details : pulmonologist_details) {
                    for (String detail : details) {
                        doctorList.add(detail);
                    }
                }
                intent.putStringArrayListExtra("doctorList", doctorList);
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