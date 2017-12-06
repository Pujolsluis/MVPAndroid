package com.example.devs.mvplogin.di;

import android.app.Application;

import com.example.devs.mvplogin.LoginMVPApplication;
import com.example.devs.mvplogin.data.source.UserRepository;
import com.example.devs.mvplogin.data.source.UserRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Usuario on 12/6/2017.
 */

@Singleton
@Component(modules = {
        UserRepositoryModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<LoginMVPApplication> {

    UserRepository getUserRepository();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();


    }

}
