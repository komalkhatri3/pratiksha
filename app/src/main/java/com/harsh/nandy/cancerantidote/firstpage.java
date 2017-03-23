package com.harsh.nandy.cancerantidote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_firstpage, menu);
        return true;
    }
    public void change_activity(View view)
    {
        if(view== findViewById(R.id.button))
        {
            Intent i=new Intent(firstpage.this,Listofhospitals.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button2))
        {
            Intent i=new Intent(firstpage.this,book_ambulance.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button3))
        {
            Intent i=new Intent(firstpage.this,Otherservices.class);
            startActivity(i);
        }
        if(view== findViewById(R.id.button5))
        {
            Intent i=new Intent(firstpage.this,login.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
