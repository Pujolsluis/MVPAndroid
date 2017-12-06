package com.example.devs.mvplogin.ui;

import com.example.devs.mvplogin.di.ActivityScoped;
import com.example.devs.mvplogin.di.FragmentScoped;
import com.example.devs.mvplogin.ui.login.LoginContract;
import com.example.devs.mvplogin.ui.login.LoginFragment;
import com.example.devs.mvplogin.ui.login.LoginPresenter;
import com.example.devs.mvplogin.ui.signup.SignUpContract;
import com.example.devs.mvplogin.ui.signup.SignUpFragment;
import com.example.devs.mvplogin.ui.signup.SignUpPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Usuario on 12/6/2017.
 */

@Module
public abstract class AuthenticationActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract LoginContract.Presenter loginPresenter(LoginPresenter loginPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SignUpFragment signUpFragment();

    @ActivityScoped
    @Binds
    abstract SignUpContract.Presenter signupPresenter(SignUpPresenter signUpPresenter);


}
