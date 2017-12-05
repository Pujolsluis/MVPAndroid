package com.example.devs.mvplogin.util;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.devs.mvplogin.R;

import static android.support.v4.util.Preconditions.checkNotNull;


/**
 * Created by devs on 9/14/17.
 */

public class ActivityUtils {

    @SuppressLint("RestrictedApi")
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        String backStateName =  fragment.getClass().getName();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment, backStateName);
        transaction.commit();
    }

    public static void replaceFragmentInActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId){

        //Avoid Fragments stacking up in the backstack if they already exist in it
        String backStateName =  fragment.getClass().getName();

        boolean fragmentPopped = fragmentManager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Replace fragment, with fade in and fadeout animation
            // and add transaction to backstack to allow the user to undo
            // the action he just did and recover the last fragment state
            transaction.setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
            );
            transaction.replace(R.id.mainActivity_fragment, fragment);
            transaction.addToBackStack(backStateName);

            transaction.commit();
        }

    }
}
