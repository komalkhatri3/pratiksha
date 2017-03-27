package com.harsh.nandy.cancerantidote;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AmbulanceList extends Fragment {
    private static final String SELECTED_STATE = "state";

    private DatabaseHolder dbHandler;
    private String selectedState;
    private Context context;
    private OnAmbulanceListFragmentInteractionListener mListener;

    public AmbulanceList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedState = getArguments().getString(SELECTED_STATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ambulance_list, container, false);
        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAmbulanceListFragmentInteractionListener) {
            mListener = (OnAmbulanceListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAmbulanceListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        dbHandler.close();
        super.onDetach();
        mListener = null;
    }

    public interface OnAmbulanceListFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
