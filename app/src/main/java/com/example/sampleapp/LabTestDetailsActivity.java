package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView pkgname,totalcost;
    EditText ed;
    Button add2cart,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        pkgname=findViewById(R.id.carttitle);
        totalcost=findViewById(R.id.totalcost);
        ed=findViewById(R.id.etxt);
        back=findViewById(R.id.back);
        add2cart=findViewById(R.id.addtocart);
        ed.setKeyListener(null);
        Intent intent=getIntent();
        pkgname.setText(intent.getStringExtra("text1"));
        ed.setText(intent.getStringExtra("text2"));
        totalcost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });
        add2cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}