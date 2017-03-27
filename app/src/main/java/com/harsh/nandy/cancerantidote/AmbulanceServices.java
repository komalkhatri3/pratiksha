package com.harsh.nandy.cancerantidote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AmbulanceServices extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void NextPage(View view)
    {
        if(view==findViewById(R.id.button13))
        {
            Intent i=new Intent(AmbulanceServices.this,Ambulance_Hospital.class);
            startActivity(i);

        }
        if(view==findViewById(R.id.button14))
        {


        }
    }

}
