package com.example.devs.mvplogin.data.source;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 8/25/17.
 */

public class UserRepository implements UserDataSource {


    private static UserRepository INSTANCE = null;
    private final UserDataSource mUserRemoteDataSource;


    boolean mCacheIsDirty = false;

    private UserRepository (@NonNull UserDataSource userRemoteDataSource){
        mUserRemoteDataSource = checkNotNull(userRemoteDataSource);
    }

    public static UserRepository getInstance(UserDataSource userRemoteDataSource){
        if(INSTANCE == null){
            INSTANCE = new UserRepository(userRemoteDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    @Override
    public void loginUser(@NonNull String username, @NonNull String password) {

    }

    @Override
    public void getUsers(@NonNull LoadUsersDataCallBack callback) {


    }

    @Override
    public void getUser(@NonNull String userEmail, @NonNull GetUserCallback callback) {

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
