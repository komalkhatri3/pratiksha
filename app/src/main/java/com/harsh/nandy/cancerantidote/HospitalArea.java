package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class HospitalArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_area);
        Spinner myspinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(HospitalArea.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.state_name));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                if (selectedState.equals("Assam")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Dr. B. Borooach cancer instittute";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Arunachal Pradesh")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Heema Hospital";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Manipur")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Shija Hospitals and Research Center";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Meghalaya")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Civil Hospital";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Mizoram")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Regional Cancer Hospital";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Nagaland")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Eden Medical Centre";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Sikkim")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "STNM Hospital";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
                if (selectedState.equals("Tripura")) {
                    TextView name, available;
                    name = (TextView) findViewById(R.id.textView19);
                    String Name = "Agartalla Gov. Cancer hospital";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
