package com.harsh.nandy.cancerantidote;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class login extends AppCompatActivity implements SignUpFragment.OnSignUpFragmentInteractionListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();

        AppCompatButton signUpButton = (AppCompatButton) findViewById(R.id.button_signup);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpFragment signUpFragment = new SignUpFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.add(R.id.new_user_fragment_container, signUpFragment, "signUpFragment");
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.findFragmentByTag("signUpFragment").isAdded()){
            fragmentManager.beginTransaction().remove(fragmentManager.findFragmentByTag("signUpFragment"));
        }else super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction() {

    }
}
