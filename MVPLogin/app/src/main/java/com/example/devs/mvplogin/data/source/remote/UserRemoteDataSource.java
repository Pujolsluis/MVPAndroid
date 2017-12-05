package com.example.devs.mvplogin.data.source.remote;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.data.source.UserDataSource;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by devs on 8/25/17.
 */

public class UserRemoteDataSource implements UserDataSource {

    private static UserRemoteDataSource INSTANCE;

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    public static UserDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new UserRemoteDataSource();
            INSTANCE.mFirebaseDatabase = FirebaseDatabase.getInstance();
            INSTANCE.mDatabaseReference = INSTANCE.mFirebaseDatabase.getReference("user_profiles");
        }
        return INSTANCE;
    }

    private UserRemoteDataSource(){}

    @Override
    public void loginUser(@NonNull String username, @NonNull String password) {

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
