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

    interface SignUpUserCallBack{
        void onUserSignedUp();

        void onUserNotSignedUp();
    }

    void signUpUser(@NonNull UserProfile userProfile, @NonNull String password,
                    @NonNull SignUpUserCallBack callBack);

    void loginUser(@NonNull String username, @NonNull String password);

    void getUsers(@NonNull LoadUsersDataCallBack callback);

    void getUser(@NonNull String userEmail, @NonNull GetUserCallback callback);

    void saveUser(@NonNull UserProfile userProfile);

    void updateUser(@NonNull UserProfile userProfile);

    void deleteUser(@NonNull UserProfile userProfile);

    void deleteAllUsers();


}
