package com.example.sampleapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicineDetailsActivity extends AppCompatActivity {
    TextView txtName, txtDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_details);

        txtName = findViewById(R.id.txtName);
        txtDetails = findViewById(R.id.txtDetails);

        // Get the data passed from BuyMedicineActivity
        String packageName = getIntent().getStringExtra("package_name");
        String packageDetails = getIntent().getStringExtra("package_details");

        // Check if data is available and not null
        if (packageName != null && packageDetails != null) {
            txtName.setText(packageName);
            txtDetails.setText(packageDetails);
        } else {
            // Handle the case where package details are missing
            txtName.setText("Package Name not available");
            txtDetails.setText("Package details not available");
        }
    }
}
