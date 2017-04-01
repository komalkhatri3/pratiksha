package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class addhospital extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhospital);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void AddHospitalAction(View view){

        EditText name,address,ambulancecount,rating;
        name=(EditText) findViewById(R.id.t_name);
        address=(EditText) findViewById(R.id.t_address);
        ambulancecount=(EditText) findViewById(R.id.t_ambulance_count);
        rating=(EditText) findViewById(R.id.t_rating);

        Hospital hospital=new Hospital();
        hospital.setName(name.getText().toString());
        hospital.setAddress(address.getText().toString());
        hospital.setAmbulance_count(ambulancecount.getText().toString());
        hospital.setUserRating(rating.getText().toString());



    }

}
