package com.harsh.nandy.cancerantidote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class Listofhospitals extends AppCompatActivity {
    //Button button;
    //Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofhospitals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





    }
    public void changefragment(View view)
    {
       // Button btn1,btn2,btn3,btn4;

        if(view==findViewById(R.id.button7)) {
            Intent i=new Intent(Listofhospitals.this,HospitalArea.class);
            startActivity(i);
          /*  fragment = new fragment_area();
            FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.fa, fragment);
            ft.commit();*/

        }
        if(view==findViewById(R.id.button10)) {
            Intent i=new Intent(Listofhospitals.this,HospitalUser.class);
            startActivity(i);
           /* fragment = new fragment_user();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fa, fragment);
            ft.commit();*/
        }
        if(view==findViewById(R.id.button11)) {
            Intent i=new Intent(Listofhospitals.this,HospitalSpecialization.class);
            startActivity(i);
           /* fragment = new fragment_specialization();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fa, fragment);
            ft.commit();*/
        }

     /*btn1=(Button) findViewById(R.id.button7);
        btn1.setVisibility(btn1.GONE);

        btn2=(Button) findViewById(R.id.button10);
        btn2.setVisibility(btn2.GONE);
        btn3=(Button) findViewById(R.id.button11);
        btn3.setVisibility(btn3.GONE);
        btn4=(Button) findViewById(R.id.button12);
        btn4.setVisibility(btn4.GONE);*/









    }


}
