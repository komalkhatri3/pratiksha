package com.harsh.nandy.cancerantidote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class book_ambulance extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ambulance);
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
    public void NextPage(View view)
    {
        if(view==findViewById(R.id.button13))
        {
            Intent i=new Intent(book_ambulance.this,Ambulance_Hospital.class);
            startActivity(i);

        }
        if(view==findViewById(R.id.button14))
        {
            Intent i=new Intent(book_ambulance.this,Near_By_Hospital.class);
            startActivity(i);

        }
    }

}
