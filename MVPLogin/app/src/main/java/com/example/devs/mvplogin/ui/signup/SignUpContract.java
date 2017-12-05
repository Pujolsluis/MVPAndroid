package com.example.devs.mvplogin.ui.signup;

import com.example.devs.mvplogin.BasePresenter;
import com.example.devs.mvplogin.BaseView;
import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.ui.login.LoginContract;

/**
 * Created by devs on 9/15/17.
 */

public interface SignUpContract {

    interface View extends BaseView<SignUpContract.Presenter> {
        public interface onSignupButtonClickListener{
            void onSignupButtonClicked();
        }

        public interface onLoginClickListener{
            void onLoginTextViewClicked();
        }

        void setLoadingIndicator(boolean isActive);

        void showSignUpError();
    }

    interface Presenter extends BasePresenter {

        void signup(UserProfile userProfile);

    }
}