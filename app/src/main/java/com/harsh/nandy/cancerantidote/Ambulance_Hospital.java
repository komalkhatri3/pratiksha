package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Ambulance_Hospital extends AppCompatActivity {

    FragmentManager fragmentManager;
    DatabaseHolder dbHandler;


    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance__hospital);

        fragmentManager = getSupportFragmentManager();
        dbHandler = new DatabaseHolder(this);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(Ambulance_Hospital.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.state_name));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                if(selectedState.equals("Assam"))
                {
                    TextView name,available;
                    name= (TextView) findViewById(R.id.Hospital_name);
                    String Name="Dr. B. Borooach cancer instittute";
                    name.setText(Name);

                    name.setVisibility(View.VISIBLE);
                }
            /*{
                if (position > 0) {
                    String selectedState = getResources().getStringArray(R.array.state_name)[position];
//                    AmbulanceList ambulanceListFragment = new AmbulanceList();
//                    Bundle args = new Bundle();
//                    args.putString("state", selectedState);
//                    ambulanceListFragment.setArguments(args);
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
//                    fragmentTransaction.add(R.id.ambulance_list_fragment_container, ambulanceListFragment, "ambulanceListFragment");
//                    fragmentTransaction.commit();

                    String headerString = "Ambulances from " + selectedState;

                    dbHandler = new DatabaseHolder(Ambulance_Hospital.this);
                    dbHandler.open();
                    Cursor ambulanceData = dbHandler.returnSelectedStateAmbulanceAvailability(selectedState);

                    if (ambulanceData != null) {
                        ambulanceData.moveToFirst();
                        Ambulance ambulance = new Ambulance();
                        final List<Ambulance> ambulanceList = new ArrayList<>();

                        while (!ambulanceData.isAfterLast()) {
                            ambulance.setId(ambulanceData.getString(0));
                            ambulance.setHospital(ambulanceData.getString(1));
                            ambulance.setAvailability(ambulanceData.getString(2));
                            ambulanceList.add(ambulance);
                            ambulanceData.moveToNext();
                        }
                        dbHandler.close();

                        dialog = new Dialog(Ambulance_Hospital.this);
                        dialog.setContentView(R.layout.fragment_ambulance_list);
                        dialog.setTitle(headerString);
                        TableLayout tableLayout = (TableLayout) dialog.findViewById(R.id.ambulance_table);

                        for (int i = 0; i < ambulanceList.size(); i++){
                            TableRow tableRow = new TableRow(Ambulance_Hospital.this);
                            tableRow.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            TextView idTextView = new TextView(Ambulance_Hospital.this);
                            TextView hospital = new TextView(Ambulance_Hospital.this);
                            TextView availability = new TextView(Ambulance_Hospital.this);

                            String idText = "" + ambulanceList.get(i).getId() + "\t\t";
                            idTextView.setText(idText);
                            String hospitalText = ambulanceList.get(i).getHospital() + "\t\t";
                            hospital.setText(hospitalText);
                            String availabilityText = isAvailable(ambulanceList, i) + "\t\t";
                            availability.setText(availabilityText);

                            tableRow.addView(idTextView);
                            tableRow.addView(hospital);
                            tableRow.addView(availability);

                            tableLayout.addView(tableRow, i);
                        }
                    }

                    dialog.show();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //not required

            }
        });

/*        findViewById(R.id.button_insert_fake_data).setOnClickListener(new View.OnClickListener() {
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
                long i = dbHandler.insertAmbulanceData(random("array"), random("string"));
                System.out.println(i);
                dbHandler.close();
            }
        });*/
    }

    public String isAvailable(List<Ambulance> ambulanceList, int index) {
        if (ambulanceList.get(index).getAvailability()) {
            return "yes";
        } else return "no";
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}