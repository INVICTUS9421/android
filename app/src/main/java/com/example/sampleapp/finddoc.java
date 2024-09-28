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

import java.util.ArrayList;
import java.util.HashMap;

public class finddoc extends AppCompatActivity {

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
            {"Doctor Name : Dr. Deepa Sharma", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798998993", "1000"}
    };


    TextView tv;
    Button back;
    ListView listView;
    String[][] docDetails = {};
    SimpleAdapter sa;
    ArrayList<HashMap<String, String>> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctordetails);

        tv = findViewById(R.id.DocDetails);
        back = findViewById(R.id.back);
        listView = findViewById(R.id.doclistview);  // Ensure your ListView has the correct ID in your XML layout.

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        // Setting the correct doctor details based on the title
        switch (title) {
            case "Cardiologist":
                docDetails = cardiologist_details;
                break;
            case "Dentist":
                docDetails = dentist_details;
                break;
            case "Surgeon":
                docDetails = surgeon_details;
                break;
            case "Physician":
                docDetails = physician_details;
                break;
            case "Pulmonologist":
                docDetails = pulmonologist_details;
                break;
        }

        // Setting up back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(finddoc.this, HomePage.class));
            }
        });

        // Preparing list data for SimpleAdapter
        list = new ArrayList<>();
        for (String[] docDetail : docDetails) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", docDetail[0]);
            item.put("line2", docDetail[1]);
            item.put("line3", docDetail[2]);
            item.put("line4", docDetail[3]);
            item.put("line5", "Consulting Fees: " + docDetail[4]);
            list.add(item);
        }

        // Initializing SimpleAdapter with correct parameters
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,  // Assuming you have a layout file for list items
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        // Setting the adapter to ListView
        listView.setAdapter(sa);

        // Get the OnBackPressedDispatcher
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();

        // Create a new OnBackPressedCallback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button press here
                startActivity(new Intent(finddoc.this, HomePage.class));
            }
        };

        // Add the callback to the OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, callback);
    }
}