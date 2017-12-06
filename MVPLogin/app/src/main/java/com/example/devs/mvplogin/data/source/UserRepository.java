package com.example.devs.mvplogin.data.source;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by devs on 8/25/17.
 */

public class UserRepository implements UserDataSource {


    private static UserRepository INSTANCE = null;
    private final UserDataSource mUserRemoteDataSource;


    boolean mCacheIsDirty = false;


    @Inject
    UserRepository (@Remote UserDataSource userRemoteDataSource){
        mUserRemoteDataSource = checkNotNull(userRemoteDataSource);
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

    @Override
    public void signUpUser(@NonNull UserProfile userProfile, @NonNull String password,
                           @NonNull final SignUpUserCallBack callback) {
        checkNotNull(callback);
        mUserRemoteDataSource.signUpUser(userProfile, password, callback);

    }

    @Override
    public void loginUser(@NonNull String username, @NonNull String password,
                          @NonNull final LoginUserCallBack callback) {
        checkNotNull(callback);
        mUserRemoteDataSource.loginUser(username, password, callback);

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
