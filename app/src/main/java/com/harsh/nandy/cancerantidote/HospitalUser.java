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
       /* listView1=(ListView) findViewById(R.id.listuser);
        String user[]={""};
        cursor=db.getListuser();
        for(int i=0;i<cursor.getCount();i++)
        {
            user[i]=cursor.getString(i);
        }
        ArrayAdapter<String> adaptor=new ArrayAdapter<String>(HospitalUser.this,android.R.layout.simple_list_item_1,user);
        listView1.setAdapter(adaptor);*/
    }
}
