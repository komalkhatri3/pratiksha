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
import java.util.Random;

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
                String selectedState = getResources().getStringArray(R.array.state_name)[position];
                Cursor ambulanceData = dbHandler.returnSelectedStateAmbulanceAvailability(selectedState);
                if (ambulanceData != null) {
                    ambulanceData.moveToFirst();
                    int index = 0;
                    Ambulance ambulance = new Ambulance();
                    final List<Ambulance> ambulanceList = new ArrayList<>();

                    while (!ambulanceData.isAfterLast()) {

                        ambulance.setId(ambulanceData.getString(0));
                        ambulance.setHospital(ambulanceData.getString(1));
                        ambulance.setState(ambulanceData.getString((2)));
                        ambulance.setAvailable(ambulanceData.getString(3));
                        ambulanceList.add(ambulance);
                        System.out.println(ambulanceList);
                        index++;
                        ambulanceData.moveToNext();
                    }
                    dbHandler.close();
                    switch (position) {
                        case 1:
                            String Hospital, avail;
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //not required

            }
        });

        findViewById(R.id.button_insert_fake_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                findViewById(R.id.button_insert_fake_data_ambulance).setVisibility(View.VISIBLE);
                dbHandler.open();
                long i = dbHandler.insertHospitalData(random("string"), random("string"),
                        random("string"), random("number"), random("number"));
                System.out.println(i);
                dbHandler.close();
            }
        });

        findViewById(R.id.button_insert_fake_data_ambulance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.open();
                long i = dbHandler.insertAmbulanceData(random("string"), random("array"), random("string"));
                System.out.println(i);
                dbHandler.close();
            }
        });
    }

    public String random(String what){
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(10);
        switch (what){
            case "string":
                String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char tempChar;
                for (int i = 0; i < randomLength; i++){
                    tempChar = alphabets.charAt(generator.nextInt(alphabets.length()));
                    randomStringBuilder.append(tempChar);
                }
                return String.valueOf(randomStringBuilder);
            case "number":
                String numbers = "0123456789";
                int tempInt;
                for (int i = 0; i < randomLength; i++){
                    tempInt = numbers.charAt(generator.nextInt(numbers.length()));
                    randomStringBuilder.append(tempInt);
                }
                return String.valueOf(randomStringBuilder);
            case "array":
                String [] array = getResources().getStringArray(R.array.state_name);
                return array[new Random().nextInt(array.length)];
            default:
                return null;
        }
    }
}