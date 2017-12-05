package com.example.devs.mvplogin;

import android.app.Application;
import android.support.annotation.UiThread;

import com.example.devs.mvplogin.di.Application.ApplicationComponent;
import com.example.devs.mvplogin.di.Application.ApplicationModule;
import com.example.devs.mvplogin.di.Application.DaggerApplicationComponent;

import dagger.android.DaggerApplication;

/**
 * Created by Usuario on 12/5/2017.
 */

public class LoginMVPApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @UiThread
    public ApplicationComponent applicationComponent(){
        if(mApplicationComponent == null){
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}
