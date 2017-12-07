package com.example.devs.mvplogin.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.devs.mvplogin.R;
import com.example.devs.mvplogin.data.source.UserDataSource;
import com.example.devs.mvplogin.data.source.UserRepository;
import com.example.devs.mvplogin.data.source.remote.UserRemoteDataSource;
import com.example.devs.mvplogin.ui.login.LoginContract;
import com.example.devs.mvplogin.ui.login.LoginFragment;
import com.example.devs.mvplogin.ui.login.LoginPresenter;
import com.example.devs.mvplogin.ui.signup.SignUpContract;
import com.example.devs.mvplogin.ui.signup.SignUpFragment;
import com.example.devs.mvplogin.ui.signup.SignUpPresenter;
import com.example.devs.mvplogin.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthenticationActivity extends DaggerAppCompatActivity implements LoginContract.View.onLoginButtonClickListener, LoginContract.View.onSignupClickListener
        , SignUpContract.View.onSignupButtonClickListener, SignUpContract.View.onLoginClickListener {

    private static final String loginFragmentName = "LoginFragment";


    @Inject
    LoginPresenter mLoginPresenter;

    @Inject
    SignUpPresenter mSignUpPresenter;

    @Inject
    LoginFragment loginFragmentProvider;

    @Inject
    SignUpFragment signUpFragmentProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainActivity_fragment);

        if(loginFragment == null){

            loginFragment = loginFragmentProvider;

            Log.d("AuthActivity", loginFragmentProvider.toString());

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    loginFragment, R.id.mainActivity_fragment);

        }

        // Load previously saved state, if available.
        if (savedInstanceState != null) {
//            TasksFilterType currentFiltering =
//                    (TasksFilterType) savedInstanceState.getSerializable(CURRENT_FILTERING_KEY);
//            mTasksPresenter.setFiltering(currentFiltering);
        }

    }


    @Override
    public void onLoginButtonClicked() {

    }

    @Override
    public void onSignupButtonClicked() {

    }

    @Override
    public void onSignupTextViewClicked() {

        SignUpFragment signUpFragment = signUpFragmentProvider;

        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(),
                signUpFragment, R.id.mainActivity_fragment);

    }

    @Override
    public void onLoginTextViewClicked() {

        LoginFragment loginFragment = loginFragmentProvider;

        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(),
                loginFragment, R.id.mainActivity_fragment);
    }
}
