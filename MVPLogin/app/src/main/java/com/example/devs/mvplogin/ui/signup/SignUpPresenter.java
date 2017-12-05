package com.example.devs.mvplogin.ui.signup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 9/15/17.
 */

public class SignUpPresenter implements SignUpContract.Presenter {


    private final UserRepository mUserRepository;

    private final SignUpContract.View mSignUpView;

    public SignUpPresenter(@NonNull UserRepository userRepository,
                           @NonNull SignUpContract.View signUpView) {
        mUserRepository = checkNotNull(userRepository, "userRepository cannot be null!");
        mSignUpView = checkNotNull(signUpView, "signUpView cannot be null!");

        mSignUpView.setPresenter(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void signup(UserProfile userProfile, String password) {
        mSignUpView.showSignUpMessage();
    }
}
