package com.example.devs.mvplogin.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Objects;

/**
 * Immutable model class for a new User
 */

public class User {
    @NonNull
    private final String mEmail;

    @NonNull
    private final String mPassword;

    @Nullable
    private final String mFirstName;

    @Nullable
    private final String mLastName;

    public User(@NonNull String mEmail, @NonNull String mPassword, String mFirstName, String mLastName) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    @NonNull
    public String getmEmail() {
        return mEmail;
    }

    @NonNull
    public String getmPassword() {
        return mPassword;
    }

    @Nullable
    public String getmFirstName() {
        return mFirstName;
    }

    @Nullable
    public String getmLastName() {
        return mLastName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(mEmail, user.mEmail) &&
                Objects.equals(mFirstName, user.mFirstName) &&
                Objects.equals(mLastName, user.mLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mEmail);
    }

    @Override
    public String toString() {
        return "User: " + mEmail + " - " + mFirstName + " " + mLastName;
    }
}
