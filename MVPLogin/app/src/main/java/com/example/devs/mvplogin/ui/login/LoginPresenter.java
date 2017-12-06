package com.example.devs.mvplogin.ui.login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserDataSource;
import com.example.devs.mvplogin.data.source.UserRepository;
import com.example.devs.mvplogin.di.ActivityScoped;


import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 9/15/17.
 */

@ActivityScoped
public class LoginPresenter implements LoginContract.Presenter {

    private final UserRepository mUserRepository;

    @Nullable
    private LoginContract.View mLoginView;


    @Inject
    public LoginPresenter(UserRepository userRepository){
        mUserRepository = checkNotNull(userRepository, "userRepository cannot be null!");
    }



    @Override
    public void start() {

    }

    @Override
    public void takeView(LoginContract.View view) {
        this.mLoginView = view;
    }

    @Override
    public void dropView() {
        this.mLoginView = null;
    }


    public void login(String username, String password) {
        mUserRepository.loginUser(username, password, new UserDataSource.LoginUserCallBack() {
            @Override
            public void onUserLoggedIn() {
                mLoginView.showSignUpMessage("User Logged In! :D");
                mLoginView.showHomeActivity();
            }

            @Override
            public void onUserNotLoggedIn() {
                mLoginView.showSignUpMessage("User not Logged In! :(");
            }
        });
    }

}
