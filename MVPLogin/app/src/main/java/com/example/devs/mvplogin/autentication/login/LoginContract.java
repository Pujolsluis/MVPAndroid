package com.example.devs.mvplogin.autentication.login;

import com.example.devs.mvplogin.BasePresenter;
import com.example.devs.mvplogin.BaseView;
import com.example.devs.mvplogin.data.User;

/**
 * Created by devs on 8/25/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{

        public interface onLoginButtonClickListener{
            void onLoginClicked();
        }

        public interface onSignupClickListener{
            void onSignupClicked();
        }

        void setLoadingIndicator(boolean active);

        void showLoginError();

    }

    interface Presenter extends BasePresenter {

        void login(User user);

    }

}
