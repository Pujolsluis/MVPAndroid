package com.example.devs.mvplogin.login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.devs.mvplogin.R;

public class LoginActivity extends AppCompatActivity implements LoginFragment.onLoginButtonClickListener, LoginFragment.onSignupClickListener {

    private static final String loginFragmentName = "LoginFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainActivity_fragment);

        //TODO IMPLEMENT FRAGMENT IN THE ACTIVITY
        if(loginFragment == null){

            loginFragment = LoginFragment.newInstance();

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.mainActivity_fragment, loginFragment)
                    .commit();

        }




    }


    @Override
    public void onLoginClicked() {
        Toast.makeText(this, "You have logged in succesfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignupClicked() {
        Toast.makeText(this, "You have requested the signup fragment", Toast.LENGTH_SHORT).show();
    }
}
