package com.example.devs.mvplogin.ui.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devs.mvplogin.R;
import com.example.devs.mvplogin.data.UserProfile;
import com.example.devs.mvplogin.ui.home.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.devs.mvplogin.R.layout.fragment_sign_up;
import static com.google.common.base.Preconditions.checkNotNull;

public class SignUpFragment extends Fragment implements SignUpContract.View {

    @Inject
    SignUpContract.Presenter mPresenter;

    onSignupButtonClickListener mSignupCallback;
    onLoginClickListener mLoginCallback;

    @BindView(R.id.sign_up_first_name)
    EditText firstName;

    @BindView(R.id.sign_up_last_name)
    EditText lastName;

    @BindView(R.id.signup_email)
    EditText email;

    @BindView(R.id.signup_password)
    EditText password;

    @BindView(R.id.signup_confirm_password)
    EditText confirmPassword;

    @BindView(R.id.signup_button)
    Button signupButton;

    @BindView(R.id.signup_login_textView)
    TextView loginTextView;

    @BindView(R.id.sign_up_progressbar)
    ProgressBar signupProgressBar;


    public SignUpFragment(){
        //Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(fragment_sign_up, container, false);

        ButterKnife.bind(this, rootView);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().isEmpty() || firstName.getText().toString().isEmpty()
                        || lastName.getText().toString().isEmpty() || password.getText().toString().isEmpty()
                        || confirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "You must complete all fields", Toast.LENGTH_SHORT).show();
                }else{
                    if( !password.getText().toString().equals(confirmPassword.getText().toString())){
                        Toast.makeText(getContext(), "Your passwords don't match", Toast.LENGTH_SHORT).show();
                    }else{
                        UserProfile userProfile =
                                new UserProfile(email.getText().toString(), firstName.getText().toString(),
                                        lastName.getText().toString()
                                );
                        mPresenter.signup(userProfile, password.getText().toString());
                    }
                }
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginCallback.onLoginTextViewClicked();
            }
        });

        return rootView;

    }

    @Override
    public void onAttach(Context context) {

        // Get Signup callback activity
        try {
            mSignupCallback = (onSignupButtonClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement onSignupButtonClickListener"
            );
        }

        // Get login callback activity
        try {
            mLoginCallback = (onLoginClickListener) context;
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
    public void setLoadingIndicator(boolean isActive) {
        if(isActive){
            signupProgressBar.setVisibility(View.VISIBLE);
        }else{
            signupProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showSignUpError() {

    }

    @Override
    public void showHomeActivity() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
    }
}
