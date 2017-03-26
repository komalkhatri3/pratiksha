package com.harsh.nandy.cancerantidote;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Ambulance_Hospital extends AppCompatActivity {
    DatabaseHelper databseHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance__hospital);
        databseHelper=new DatabaseHelper(this);
        ListView listView= (ListView) findViewById(R.id.listview1);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Ambulance_Hospital.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.state_name));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {




            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sqLiteDatabase=databseHelper.getReadableDatabase();
                final List<Ambulance> AmbulanceAvail= new ArrayList<Ambulance>();
                Log.d("MESSAGE","In onItemSelected ");
                cursor = databseHelper.getdata(mySpinner.getSelectedItem().toString());
                if(cursor.moveToFirst())
                    do
                    {
                        Ambulance ambulance =new Ambulance();
                        ambulance.setHospital(cursor.getString(0));
                        ambulance.setState(cursor.getString((1)));
                        ambulance.setAvailable(cursor.getInt(2));
                        AmbulanceAvail.add(ambulance);

                    }while (cursor.moveToNext());
                Adaptor adaptor;
                adaptor = new Adaptor(this,AmbulanceAvail);

                switch (position)
                {
                    case 1:

                             String Hospital,avail;




                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                     default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}