package com.example.devs.mvplogin.login;

import com.example.devs.mvplogin.BasePresenter;
import com.example.devs.mvplogin.BaseView;
import com.example.devs.mvplogin.data.User;

/**
 * Created by devs on 8/25/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);

        void showLoginError();

    }

    interface Presenter extends BasePresenter {

        void login(User user);

    }

}
