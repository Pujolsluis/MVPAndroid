package com.example.devs.mvplogin.data.source;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.UserProfile;

import java.util.List;

/**
 * Created by devs on 8/25/17.
 */

public interface UserDataSource {

    interface LoadUsersDataCallBack{

        void onUserDataloaded(List<UserProfile> userProfiles);

        void onDataNotAvailable();
    }

    interface GetUserCallback{

        void onUserLoaded(UserProfile userProfile);

        void onDataNotAvailable();
    }

    void getUsers(@NonNull LoadUsersDataCallBack callback);

    void getUser(@NonNull String userEmail, @NonNull GetUserCallback callback);

    void saveUser(@NonNull UserProfile userProfile);

    void updateUser(@NonNull UserProfile userProfile);

    void deleteUser(@NonNull UserProfile userProfile);

    void deleteAllUsers();


}
