package com.harsh.nandy.cancerantidote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class fragment_area extends Fragment {

    public fragment_area() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_area, container, false);
        Spinner myspinner = (Spinner) view.findViewById(R.id.spinner_area);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.state_name));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);

            return  view;



    }

}