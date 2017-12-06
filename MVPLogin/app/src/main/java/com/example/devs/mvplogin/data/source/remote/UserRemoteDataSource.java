package com.example.devs.mvplogin.data.source.remote;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserDataSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by devs on 8/25/17.
 */

@Singleton
public class UserRemoteDataSource implements UserDataSource {

    private static UserRemoteDataSource INSTANCE;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mFirebaseAuth;


    @Inject
    UserRemoteDataSource(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("user_profiles");
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signUpUser(@NonNull UserProfile userProfile, @NonNull String password,
                           @NonNull final SignUpUserCallBack callback) {

        mFirebaseAuth.createUserWithEmailAndPassword(userProfile.getmEmail(), password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Task completed successfully
                            AuthResult result = task.getResult();
                            callback.onUserSignedUp();
                        } else {
                            // Task failed with an exception
                            Exception exception = task.getException();
                            callback.onUserNotSignedUp();
                        }
                    }
                });
    }

    @Override
    public void loginUser(@NonNull String username, @NonNull String password,
                          @NonNull final LoginUserCallBack callback) {

        mFirebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Task completed successfully
                            AuthResult result = task.getResult();
                            callback.onUserLoggedIn();
                        } else {
                            // Task failed with an exception
                            Exception exception = task.getException();
                            callback.onUserNotLoggedIn();
                        }
                    }
                });

    }

    @Override
    public void getUsers(@NonNull LoadUsersDataCallBack callback) {

    }

    @Override
    public void getUser(@NonNull String userID, @NonNull GetUserCallback callback) {

    }

    @Override
    public void saveUser(@NonNull UserProfile userProfile) {

    }

    @Override
    public void updateUser(@NonNull UserProfile userProfile) {

    }

    @Override
    public void deleteUser(@NonNull UserProfile userProfile) {

    }

    @Override
    public void deleteAllUsers() {

    }
}
