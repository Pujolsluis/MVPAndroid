package com.example.devs.mvplogin.ui.login;

import com.example.devs.mvplogin.BasePresenter;
import com.example.devs.mvplogin.BaseView;
import com.example.devs.mvplogin.data.UserProfile;

/**
 * Created by devs on 8/25/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{

        public interface onLoginButtonClickListener{
            void onLoginButtonClicked();
        }

        public interface onSignupClickListener{
            void onSignupTextViewClicked();
        }

        void setLoadingIndicator(boolean active);

        void showLoginError();

    }

    interface Presenter extends BasePresenter {

        void login(String username, String password);

    }

}
