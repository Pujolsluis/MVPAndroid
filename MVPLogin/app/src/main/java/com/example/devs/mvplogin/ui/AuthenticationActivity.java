package com.example.devs.mvplogin.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

public class AuthenticationActivity extends AppCompatActivity implements LoginContract.View.onLoginButtonClickListener, LoginContract.View.onSignupClickListener
        , SignUpContract.View.onSignupButtonClickListener, SignUpContract.View.onLoginClickListener {

    private static final String loginFragmentName = "LoginFragment";

    LoginPresenter mLoginPresenter;
    SignUpPresenter mSignUpPresenter;

    LoginFragment loginFragment;

    SignUpFragment signUpFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainActivity_fragment);

        if(loginFragment == null){

            loginFragment = LoginFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    loginFragment, R.id.mainActivity_fragment);

        }

        UserRepository userRepository = UserRepository.getInstance(UserRemoteDataSource.getInstance());
        mLoginPresenter = new LoginPresenter( userRepository, loginFragment);

        signUpFragment = SignUpFragment.newInstance();
        mSignUpPresenter = new SignUpPresenter( userRepository, signUpFragment);

    }


    @Override
    public void onLoginButtonClicked() {

    }

    @Override
    public void onSignupButtonClicked() {

    }

    @Override
    public void onSignupTextViewClicked() {
        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(),
                signUpFragment, R.id.mainActivity_fragment);

    }

    @Override
    public void onLoginTextViewClicked() {
        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(),
                loginFragment, R.id.mainActivity_fragment);
    }
}
