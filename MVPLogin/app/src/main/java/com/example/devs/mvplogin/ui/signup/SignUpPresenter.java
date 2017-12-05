package com.example.devs.mvplogin.ui.signup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserDataSource;
import com.example.devs.mvplogin.data.source.UserRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 9/15/17.
 */

public class SignUpPresenter implements SignUpContract.Presenter {


    private final UserRepository mUserRepository;

    private final SignUpContract.View mSignUpView;
    private FirebaseAuth mFirebaseAuth;

    public SignUpPresenter(@NonNull UserRepository userRepository,
                           @NonNull SignUpContract.View signUpView) {
        mUserRepository = checkNotNull(userRepository, "userRepository cannot be null!");
        mSignUpView = checkNotNull(signUpView, "signUpView cannot be null!");

        mSignUpView.setPresenter(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void start() {

    }

    @Override
    public void signup(UserProfile userProfile, String password) {

        mUserRepository.signUpUser(userProfile, password,
                new UserDataSource.SignUpUserCallBack() {
                    @Override
                    public void onUserSignedUp() {
                        mSignUpView.showSignUpMessage("User Registered! :D");
                    }

                    @Override
                    public void onUserNotSignedUp() {
                        mSignUpView.showSignUpMessage("User Not Registered! :(");
                    }
                });

    }
}
