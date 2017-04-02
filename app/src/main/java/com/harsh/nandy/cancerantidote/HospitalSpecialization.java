package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class HospitalSpecialization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_specialization);
        Spinner myspinner=(Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter;
        myAdapter = new ArrayAdapter<String>(HospitalSpecialization.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cancer_types));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);

    }
}
