package com.example.sampleapp;
import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
public class BuyMedicineActivity extends AppCompatActivity {
    String[][] packages = {
            {"Uprise-D3 1000IU Capsule", "", "", "", "50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
            {"Vitamin B Complex Capsules", "", "", "", "448"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "", "539"},
            {"Dolo 650 Tablet", "", "", "", "30"},
            {"Crocin 650 Advance Tablet", "", "", "", "50"},
            {"Strepsils Medicated Lozenges for Sore Throat", "", "", "", "40"},
            {"Tata 1mg Calcium + Vitamin D3", "", "", "", "30"},
            {"Feronia -XT Tablet", "", "", "", "130"}
    };

    String[] package_details = {
            "Building and keeping the bones & teeth strong\n",
            "Reducing Fatigue/stress and muscular pains\n",
            "Boosting immunity and increasing resistance against infection\n",
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulate blood sugar\n",
            "Provides relief from vitamin B deficiencies\n",
            "Helps in formation of red blood cells\n",
            "Maintains healthy nervous system\n",
            "It promotes health as well as skin benefit.\n",
            "It helps reduce skin blemish and pigmentation.\n",
            "It acts as safeguard the skin from the harsh UVA and UVB sun rays.\n",
            "Dolo 650 Tablet helps relieve pain and fever\n",
            "Helps relieve fever and bring down a high temperature\n",
            "Suitable for people with a heart condition or high blood pressure\n",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n",
            "Provides a warm and comforting feeling during sore throat\n",
            "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n",
            "Promotes mobility and flexibility of joints\n",
            "Helps to reduce iron deficiency due to chronic blood loss or low intake of iron"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnback,btncart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buymedicine);
        lst=findViewById(R.id.listmed);
        btnback=findViewById(R.id.btnback);
        btncart=findViewById(R.id.btncart);
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(BuyMedicine.this,CartBuyMedicine.class));
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomePage.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        //sa = new SimpleAdapter(this,list,R.layout.multi_lines);
    }
}
