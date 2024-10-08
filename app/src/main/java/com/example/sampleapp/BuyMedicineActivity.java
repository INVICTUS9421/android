package com.example.sampleapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list1;
    SimpleAdapter sa;
    ListView lst;
    Button btnback, btncart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buymedicine);

        lst = findViewById(R.id.listmed);
        btnback = findViewById(R.id.btnback);
        btncart = findViewById(R.id.btncart);

        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement cart functionality
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomePage.class));
            }
        });

        list1 = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<>();
            item.put("line_a", packages[i][0]);
            item.put("line_b", packages[i][1]);
            item.put("line_c", packages[i][2]);
            item.put("line_d", packages[i][3]);
            item.put("line_e", "Total Cost: " + packages[i][4] + "/-");
            list1.add(item);
        }

        sa = new SimpleAdapter(this, list1, R.layout.multi_lines,
                new String[]{"line_a", "line_b", "line_c", "line_d", "line_e"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        // Set OnItemClickListener to handle clicks on ListView items
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Check if the clicked item has valid data
                if (position >= 0 && position < packages.length) {
                    String packageName = packages[position][0];
                    String packageDetails = package_details[position];

                    // Handle null or empty data
                    if (packageName != null && packageDetails != null) {
                        Intent intent = new Intent(BuyMedicineActivity.this, MedicineDetailsActivity.class);
                        intent.putExtra("package_name", packageName); // Pass package name
                        intent.putExtra("package_details", packageDetails); // Pass package details
                        startActivity(intent);
                    } else {
                        // If null, display a toast message or handle error appropriately
                        Toast.makeText(BuyMedicineActivity.this, "Invalid package data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
