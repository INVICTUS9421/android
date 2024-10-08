package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    Button button;

    ArrayList<HashMap<String, String>> list1;
    SimpleAdapter sa;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctordetails);

        // Get the ListView from the layout
        lst = findViewById(R.id.doclistview);

        list1 = new ArrayList<>();
        ArrayList<String> doctorList = getIntent().getStringArrayListExtra("doctorList");
        if (doctorList != null) {
            for (String doctor : doctorList) {
                String[] doctorDetails = doctor.split(",");
                HashMap<String, String> item = new HashMap<>();
                item.put("line_a", doctorDetails[0]);
                item.put("line_b", doctorDetails[1]);
                item.put("line_c", doctorDetails[2]);
                item.put("line_d", doctorDetails[3]);
                item.put("line_e", "Total Cost:" + doctorDetails[4] + "/-");
                list1.add(item);
            }
        }
        sa = new SimpleAdapter(this, list1, R.layout.multi_lines,
                new String[]{"line_a", "line_b", "line_c", "line_d", "line_e"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorDetails.this, finddoc.class);
                startActivity(intent);
            }
        });
    }
}