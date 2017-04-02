package com.harsh.nandy.cancerantidote;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class HospitalUser extends AppCompatActivity {
    ListView listView1;
    Cursor cursor;
    DatabaseHolder db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_user);

    }
}
