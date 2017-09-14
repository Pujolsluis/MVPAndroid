package com.example.devs.mvplogin.login;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.devs.mvplogin.R;

public class LoginActivity extends AppCompatActivity implements LoginFragment.onLoginButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFragment = LoginFragment.;

    }


    @Override
    public void onLoginClicked() {
        Toast.makeText(this, "You have logged in succesfully", Toast.LENGTH_SHORT).show();
    }
}
