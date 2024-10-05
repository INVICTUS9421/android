package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages={
            {"Package 1 : Full Body CheckUp","","","","999"},
            {"Package 2 : Blood Gulcose Fasting","","","","299"},
            {"Package 3 :COVID - 19 Antibody - IgG","","","","899"},
            {"Package 4 : Thiroid Check","","","","499"},
            {"Package 5 : Immunity Check","","","","699"}
    };
    private String[] package_details={
            "Blood Glucose Fasting\n"+
                    "Complete Hemogram\n"+
                    "HbA1c\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "LDH Lactate Dehydrogenase, Serum\n"+
                    "Lipid Profile"+
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID - 19 Antibody - IgG",
            "Thyroid Profile-Total (T3,T4 & TSH Ultra-sensetive)",
            "Complet Hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative, Serum\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test"+
                    "Vitamin D Total-25 Hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"
    };
    HashMap<String,String> item=new HashMap<String,String>();
    ArrayList list;
    SimpleAdapter sa;
    Button g2cart,back;
    ListView lview;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_test);
        g2cart=findViewById(R.id.cart);
        back=findViewById(R.id.back);
        lview=findViewById(R.id.lview);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomePage.class));
            }
        });
        for(int i=0;i<packages.length;i++){
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost : "+packages[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lview.setAdapter(sa);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                             Intent it=new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                                             it.putExtra("text1",packages[i][0]);
                                             it.putExtra("text2",package_details[i]);
                                             it.putExtra("text3",packages[i][4]);
                                             startActivity(it);
                                         }
                                     }

        );
        g2cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });

    }
}
