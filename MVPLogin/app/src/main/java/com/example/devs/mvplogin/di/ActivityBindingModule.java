package com.example.devs.mvplogin.di;

import com.example.devs.mvplogin.ui.AuthenticationActivity;
import com.example.devs.mvplogin.ui.AuthenticationActivityModule;
import com.example.devs.mvplogin.ui.home.HomeActivity;
import com.example.devs.mvplogin.ui.home.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Usuario on 12/6/2017.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = AuthenticationActivityModule.class)
    abstract AuthenticationActivity authenticationActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity homeActivity();

}
