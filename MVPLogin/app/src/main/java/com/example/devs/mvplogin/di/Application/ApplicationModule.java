package com.example.devs.mvplogin.di.Application;

import android.app.Application;

import com.example.devs.mvplogin.data.source.UserDataSource;
import com.example.devs.mvplogin.data.source.UserRepository;
import com.example.devs.mvplogin.data.source.remote.UserRemoteDataSource;
import com.example.devs.mvplogin.ui.login.LoginFragment;
import com.example.devs.mvplogin.ui.login.LoginPresenter;
import com.example.devs.mvplogin.ui.signup.SignUpFragment;
import com.example.devs.mvplogin.ui.signup.SignUpPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Usuario on 12/5/2017.
 */

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationScope
    Application application(){
        return mApplication;
    }

    @Provides
    @ApplicationScope
    UserDataSource userRemoteDataSource(){
        return UserRemoteDataSource.getInstance();
    }

    @Provides
    @ApplicationScope
    UserRepository userRepository(UserDataSource userRemoteDataSource){
        return UserRepository.getInstance(userRemoteDataSource);
    }


    @Provides
    @ApplicationScope
    LoginFragment loginFragment(){
        return LoginFragment.newInstance();
    }

    @Provides
    @ApplicationScope
    LoginPresenter loginPresenter(UserRepository userRepository, LoginFragment loginFragment){
        return new LoginPresenter(userRepository, loginFragment);
    }

    @Provides
    @ApplicationScope
    SignUpFragment signUpFragment(){
        return SignUpFragment.newInstance();
    }

    @Provides
    @ApplicationScope
    SignUpPresenter signUpPresenter(UserRepository userRepository, SignUpFragment signUpFragment){
        return new SignUpPresenter(userRepository, signUpFragment);
    }


}
