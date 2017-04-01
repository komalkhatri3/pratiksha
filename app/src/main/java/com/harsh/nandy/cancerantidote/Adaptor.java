package com.harsh.nandy.cancerantidote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by popla on 26-03-2017.
 */

public class Adaptor {
    public Context context;
    public List<Ambulance> AmbulanceAvail;


    public Adaptor(Context context, List<Ambulance> AmbulanceAvail) {
        this.context= context;
        this.AmbulanceAvail = AmbulanceAvail;
    }

    public Adaptor(AdapterView.OnItemSelectedListener onItemSelectedListener, List<Ambulance> ambulanceList) {

    }

    public int getCount() {
        return AmbulanceAvail.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.list_eleme,null);
        TextView name=(TextView) view.findViewById(R.id.name);
        Ambulance ambulance =AmbulanceAvail.get(position);
        name.setText(ambulance.getHospital());
        return view;





    }

}
