package com.example.devs.mvplogin.autentication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.devs.mvplogin.R;
import com.example.devs.mvplogin.autentication.login.LoginContract;
import com.example.devs.mvplogin.autentication.login.LoginFragment;
import com.example.devs.mvplogin.autentication.signup.SignUpFragment;
import com.example.devs.mvplogin.util.ActivityUtils;

public class AuthenticationActivity extends AppCompatActivity implements LoginContract.View.onLoginButtonClickListener, LoginContract.View.onSignupClickListener {

    private static final String loginFragmentName = "LoginFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment mainActivityFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainActivity_fragment);

        //TODO IMPLEMENT FRAGMENT IN THE ACTIVITY
        if(mainActivityFragment == null){

            mainActivityFragment = LoginFragment.newInstance();

//            FragmentManager fragmentManager = getSupportFragmentManager();
//
//            fragmentManager.beginTransaction()
//                    .add(R.id.mainActivity_fragment, mainActivityFragment)
//                    .commit();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mainActivityFragment, R.id.mainActivity_fragment);

        }


    }


    @Override
    public void onLoginClicked() {

    }

    @Override
    public void onSignupClicked() {

        SignUpFragment signUpFragment = (SignUpFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainActivity_fragment);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                signUpFragment, R.id.mainActivity_fragment);

    }
}
