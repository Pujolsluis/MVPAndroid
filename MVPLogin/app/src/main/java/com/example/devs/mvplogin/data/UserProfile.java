package com.example.devs.mvplogin.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Objects;

/**
 * Immutable model class for a new UserProfile
 */

public class UserProfile {
    @Nullable
    private String mEmail;

    @Nullable
    private String mFirstName;

    @Nullable
    private String mLastName;

    public UserProfile(){

        mEmail  = mFirstName = mLastName = null;

    }

    public UserProfile(@NonNull String mEmail, String mFirstName, String mLastName) {
        this.mEmail = mEmail;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    @NonNull
    public String getmEmail() {
        return mEmail;
    }

    @Nullable
    public String getmFirstName() {
        return mFirstName;
    }

    @Nullable
    public String getmLastName() {
        return mLastName;
    }

    public void setmEmail(@Nullable String mEmail) {
        this.mEmail = mEmail;
    }

    public void setmFirstName(@Nullable String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmLastName(@Nullable String mLastName) {
        this.mLastName = mLastName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        UserProfile userProfile = (UserProfile) obj;
        return Objects.equals(mEmail, userProfile.mEmail) &&
                Objects.equals(mFirstName, userProfile.mFirstName) &&
                Objects.equals(mLastName, userProfile.mLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mEmail);
    }

    @Override
    public String toString() {
        return "UserProfile: " + mEmail + " - " + mFirstName + " " + mLastName;
    }
}
