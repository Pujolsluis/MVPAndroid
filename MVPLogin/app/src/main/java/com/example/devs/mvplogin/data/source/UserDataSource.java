package com.example.devs.mvplogin.data.source;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.User;

import java.util.List;

/**
 * Created by devs on 8/25/17.
 */

public interface UserDataSource {

    interface LoadUsersDataCallBack{

        void onUserDataloaded(List<User> users);

        void onDataNotAvailable();
    }

    interface GetUserCallback{

        void onUserLoaded(User user);

        void onDataNotAvailable();
    }

    void getUsers(@NonNull LoadUsersDataCallBack callback);

    void getUser(@NonNull String userEmail, @NonNull GetUserCallback callback);

    void saveUser(@NonNull User user);

    void updateUser(@NonNull User user);

    void deleteUser(@NonNull User user);

    void deleteAllUsers();


}
