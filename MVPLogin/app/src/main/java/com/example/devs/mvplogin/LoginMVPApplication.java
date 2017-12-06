package com.example.devs.mvplogin;


import com.example.devs.mvplogin.data.source.UserRepository;
import com.example.devs.mvplogin.di.DaggerAppComponent;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Usuario on 12/5/2017.
 */

public class LoginMVPApplication extends DaggerApplication {

    @Inject
    UserRepository mUserRepository;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }


}
