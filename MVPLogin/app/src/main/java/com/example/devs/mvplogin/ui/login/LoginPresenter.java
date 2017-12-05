package com.example.devs.mvplogin.ui.login;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserDataSource;
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

        mLoginView.setPresenter(this);
    }



    @Override
    public void start() {

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
