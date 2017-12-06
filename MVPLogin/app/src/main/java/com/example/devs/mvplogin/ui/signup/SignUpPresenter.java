package com.example.devs.mvplogin.ui.signup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserDataSource;
import com.example.devs.mvplogin.data.source.UserRepository;
import com.example.devs.mvplogin.ui.home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 9/15/17.
 */

public class SignUpPresenter implements SignUpContract.Presenter {


    private final UserRepository mUserRepository;

    @Nullable
    private SignUpContract.View mSignUpView;

    public SignUpPresenter(UserRepository userRepository) {
        mUserRepository = checkNotNull(userRepository, "userRepository cannot be null!");
    }


    @Override
    public void start() {

    }

    @Override
    public void takeView(SignUpContract.View view) {
        mSignUpView = view;
    }

    @Override
    public void dropView() {
        mSignUpView = null;
    }

    @Override
    public void signup(UserProfile userProfile, String password) {

        mUserRepository.signUpUser(userProfile, password,
                new UserDataSource.SignUpUserCallBack() {
                    @Override
                    public void onUserSignedUp() {
                        if (mSignUpView != null) {
                            mSignUpView.showSignUpMessage("User Registered! :D");
                        }
                        if (mSignUpView != null) {
                            mSignUpView.showHomeActivity();
                        }
                    }

                    @Override
                    public void onUserNotSignedUp() {
                        if (mSignUpView != null) {
                            mSignUpView.showSignUpMessage("User Not Registered! :(");
                        }
                    }
                });

    }
}
