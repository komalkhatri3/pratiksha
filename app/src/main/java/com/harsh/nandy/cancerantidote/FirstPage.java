package com.harsh.nandy.cancerantidote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_firstpage, menu);
        return true;
    }
    public void change_activity(View view)
    {
        if(view== findViewById(R.id.button_list_of_hospitals))
        {
            Intent i=new Intent(FirstPage.this,Listofhospitals.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button_ambulance_services))
        {
            Intent i=new Intent(FirstPage.this,AmbulanceServices.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button_other_services))
        {
            Intent i=new Intent(FirstPage.this,Otherservices.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button_login_signup))
        {
           ;
        }
        if(view== findViewById(R.id.button_what_is_cancer))
        {
            Intent i=new Intent(FirstPage.this,WhatIsCancer.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button_cancer_symptoms))
        {
            Intent i=new Intent(FirstPage.this,CancerSymptoms.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button_cancer_symptoms))
        {
            Intent i=new Intent(FirstPage.this,CancerSymptoms.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button_list_of_hospitals, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
