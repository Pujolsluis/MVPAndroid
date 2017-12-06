package com.example.devs.mvplogin.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devs.mvplogin.R;
import com.example.devs.mvplogin.ui.home.HomeActivity;
import com.example.devs.mvplogin.ui.signup.SignUpContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.devs.mvplogin.R.layout.fragment_login;
import static com.google.common.base.Preconditions.checkNotNull;

public class LoginFragment extends Fragment implements LoginContract.View {

    @Inject
    LoginContract.Presenter mPresenter;

    onLoginButtonClickListener mLoginCallback;
    onSignupClickListener mSignupCallback;

    @BindView(R.id.login_email_textView)
    EditText email;

    @BindView(R.id.login_password_textView)
    EditText password;

    @BindView(R.id.login_buttonView)
    Button loginButton;

    @BindView(R.id.login_signup_TextView)
    TextView signupTextView;

    @BindView(R.id.login_progress_bar)
    ProgressBar progressBar;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(fragment_login, container, false);
        ButterKnife.bind(this, rootView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(email.getText().toString())){
                Toast.makeText(getContext(), "You must complete all fields", Toast.LENGTH_SHORT).show();
            }else{
                mPresenter.login(email.getText().toString(), password.getText().toString());
            }
            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSignupCallback.onSignupTextViewClicked();
            }
        });


        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        // Get Signup callback activity
        try {
            mSignupCallback = (LoginContract.View.onSignupClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement onSignupButtonClickListener"
            );
        }

        // Get login callback activity
        try {
            mLoginCallback = (LoginContract.View.onLoginButtonClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement onLoginClickListener"
            );
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        mSignupCallback = null;
        mLoginCallback = null;
        super.onDetach();
    }

    @Override
    public void onResume() {
        mPresenter.takeView(this);
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }

    @Override
    public void showSignUpMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showHomeActivity() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        startActivity(intent);

    }

    @Override
    public void setLoadingIndicator(boolean isActive) {
        if(isActive) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoginError() {

    }
}
