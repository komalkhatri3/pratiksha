package com.harsh.nandy.cancerantidote;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Ambulance_Hospital extends AppCompatActivity {
    DatabaseHolder dbHandler = new DatabaseHolder(this);
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance__hospital);
        ListView listView= (ListView) findViewById(R.id.Listview1);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Ambulance_Hospital.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.state_name));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dbHandler.open();
                Cursor ambulanceData = dbHandler.returnHospitalData();

                final List<Ambulance> AmbulanceAvail= new ArrayList<Ambulance>();
                if(cursor.moveToFirst())
                    do
                    {
                        Ambulance ambulance =new Ambulance();
                        ambulance.setHospital(cursor.getString(1));
                        ambulance.setState(cursor.getString((2)));
                        ambulance.setAvailable(cursor.getInt(3));
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
                //not required

            }
        });

        findViewById(R.id.button_insert_fake_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.open();

            }
        });
    }
}