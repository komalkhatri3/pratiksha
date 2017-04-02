package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import static com.harsh.nandy.cancerantidote.R.id.textview2;

public class WhatIsCancer extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_is_cancer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textview2);
        loadText();
    }



    private void loadText()
    {
        String s="";
        for(int x=0;x<100;x++){
            s+="lINE: "+String.valueOf(x)+"\n";
        }
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(s);


    }

}
