package com.example.devs.mvplogin.di.Application;

import com.example.devs.mvplogin.LoginMVPApplication;

import dagger.Component;

/**
 * Created by Usuario on 12/5/2017.
 */


@ApplicationScope
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {
        public void inject(LoginMVPApplication loginMVPApplication);

}
