package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListMedicine extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctordetails);

        // Get the ListView from the layout
        ListView listView = findViewById(R.id.doclistview);

        // Get the list of doctors that was passed as an extra
        ArrayList<String> doctorList = getIntent().getStringArrayListExtra("doctorList");

        // Create an ArrayAdapter to display the list of doctors in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doctorList);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListMedicine.this,BuyMedicineActivity.class);
                startActivity(intent);
            }
        });
    }
}