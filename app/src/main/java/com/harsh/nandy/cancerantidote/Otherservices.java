package com.harsh.nandy.cancerantidote;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Otherservices extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherservices);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }



public void onClick(View v) {

    if (v == findViewById(R.id.button_video_calling)) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri.parse("http://www.skype.com");;
        startActivity(intent);
    }
    if (v == findViewById(R.id.button_counselling_service)) {
        Intent intent = new Intent(Otherservices.this, Counselling.class);
        startActivity(intent);
    }
       if(v==findViewById(R.id.button_ivr)) {
            Intent i = new Intent(Otherservices.this, Ivr.class);
            startActivity(i);
        }
    if(v==findViewById(R.id.button_vns)) {
        Intent i=new Intent(Otherservices.this,Vns.class);
        startActivity(i);
    }
    if(v==findViewById(R.id.button_vns)) {
        Intent i=new Intent(Otherservices.this,Vns.class);
        startActivity(i);
    }


}}
