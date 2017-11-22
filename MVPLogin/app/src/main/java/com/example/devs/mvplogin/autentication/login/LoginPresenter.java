package com.example.devs.mvplogin.autentication.login;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserRepository;


import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 9/15/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final UserRepository mUserRepository;

    private final LoginContract.View mLoginView;


    public LoginPresenter(@NonNull UserRepository userRepository,
                          @NonNull LoginContract.View loginView){
        mUserRepository = checkNotNull(userRepository, "userRepository cannot be null!");
        mLoginView = checkNotNull(loginView, "loginView cannot be null!");
    }



    @Override
    public void start() {

    }

    @Override
    public void login(UserProfile userProfile) {

    }
}
