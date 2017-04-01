package com.harsh.nandy.cancerantidote;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class fragment_user extends Fragment {
    private static ListView listView1;
    Cursor cursor;
    DatabaseHolder db;



    public fragment_user() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_user, container, false);
        listView1=(ListView) view.findViewById(R.id.list_user);
        String user[]={""};
        for(int i=0;i<cursor.getCount();i++)
        {
            user[i]=cursor.getString(i);
        }
        ArrayAdapter<String> adaptor=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,user);
        listView1.setAdapter(adaptor);
        return view;
    }



}