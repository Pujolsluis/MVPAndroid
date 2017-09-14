package com.example.devs.mvplogin.data.source;

import android.support.annotation.NonNull;

import com.example.devs.mvplogin.data.User;

/**
 * Created by devs on 8/25/17.
 */

public class UserRepository implements UserDataSource {


    private static UserRepository INSTANCE = null;







    @Override
    public void getUsers(@NonNull LoadUsersDataCallBack callback) {


    }

    @Override
    public void getUser(@NonNull String userEmail, @NonNull GetUserCallback callback) {

    }

    @Override
    public void saveUser(@NonNull User user) {

    }

    @Override
    public void updateUser(@NonNull User user) {

    }

    @Override
    public void deleteUser(@NonNull User user) {

    }

    @Override
    public void deleteAllUsers() {

    }
}
