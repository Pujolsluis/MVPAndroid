package com.example.devs.mvplogin.data.source;

import com.example.devs.mvplogin.data.source.remote.UserRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Usuario on 12/6/2017.
 */

@Module
abstract public class UserRepositoryModule {

    @Singleton
    @Binds
    @Remote
    abstract UserDataSource userRemoteDataSource(UserRemoteDataSource userRemoteDataSource);

}
