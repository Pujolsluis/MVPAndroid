package com.example.devs.mvplogin.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Usuario on 12/6/2017.
 */

@Module
public abstract class ApplicationModule {

    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);

}
