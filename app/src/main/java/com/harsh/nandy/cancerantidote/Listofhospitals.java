package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import static android.R.attr.id;

public class Listofhospitals extends AppCompatActivity {
    //Button button;
    //Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofhospitals);
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
     /*   button=(Button) findViewById(R.id.button7);
            button.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    fragment = new fragment_specialization();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.fa, fragment);
                    ft.commit();
                }
            });*/


    }
    public void changefragment(View view)
    {
       Fragment fragment;
        if(view==findViewById(R.id.button7)) {
            fragment = new fragment_area();
            FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fa, fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.button10)) {
            fragment = new fragment_user();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fa, fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.button11)) {
            fragment = new fragment_specialization();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fa, fragment);
            ft.commit();
        }


        
    }

}
