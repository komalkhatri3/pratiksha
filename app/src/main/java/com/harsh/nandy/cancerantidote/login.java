package com.harsh.nandy.cancerantidote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                transaction.add(R.id.new_user_fragment_container, signUpFragment, "signUpFragment").commit();
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            }
        });
    }
    public void LogIn(View view)
    {
        EditText username= (EditText) findViewById(R.id.editText);
        EditText password=(EditText) findViewById(R.id.editText2);
        if(username.getText().toString().equals("Ram")){
            if(password.getText().toString().equals("1234"))
            {
                Intent intent =new Intent(login.this,FirstPage.class);
                startActivity(intent);
            }
        }
        else if(username.getText().toString().equals("Sarthak")){
            if(password.getText().toString().equals("1234"))
            {
                Intent intent =new Intent(login.this,FirstPage.class);
                startActivity(intent);
            }
        }
        else if(username.getText().toString().equals("Tanvi")){
            if(password.getText().toString().equals("1234"))
            {
                Intent intent =new Intent(login.this,FirstPage.class);
                startActivity(intent);
            }
        }

        else if(username.getText().toString().equals("Pratiksha")){
            if(password.getText().toString().equals("1234"))
            {
                Intent intent =new Intent(login.this,FirstPage.class);
                startActivity(intent);
            }
        }
        else if(username.getText().toString().equals("Komal")){
            if(password.getText().toString().equals("1234"))
            {
                Intent intent =new Intent(login.this,FirstPage.class);
                startActivity(intent);;
            }
        }
        else
        {
            Context context=getApplicationContext();
            Toast.makeText(context,"invalid username or id",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.findFragmentByTag("signUpFragment") != null){
            if (fragmentManager.findFragmentByTag("signUpFragment").isAdded())
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentByTag("signUpFragment")).commit();
        }else super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction() {

    }
}
