package com.example.devs.mvplogin.autentication.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devs.mvplogin.R;

import static com.example.devs.mvplogin.R.layout.fragment_login;

public class LoginFragment extends Fragment implements LoginContract.View {

    onLoginButtonClickListener mLoginCallback;
    onSignupClickListener mSignupCallback;
    EditText email;
    EditText password;
    Button loginButton;
    TextView signupTextView;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(){

        LoginFragment loginFragment = new LoginFragment();

        return loginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(fragment_login, container, false);
        email = rootView.findViewById(R.id.login_email_textView);
        password = rootView.findViewById(R.id.login_password_textView);
        loginButton = rootView.findViewById(R.id.login_buttonView);
        signupTextView = rootView.findViewById(R.id.login_signup_TextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(getContext(), "You must complete all fields", Toast.LENGTH_SHORT).show();
                }else{
                    mLoginCallback.onLoginClicked();
                }

            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSignupCallback.onSignupClicked();
            }
        });


        return rootView;

    }

    @Override
    public void onAttach(Context context) {

        //Get Login callback activity
        try {
            mLoginCallback = (onLoginButtonClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement onLoginButtonClickListener"
            );
        }

        //Get Signup callback activity
        try{
            mSignupCallback = (onSignupClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + "must implement onSignupClickListener"
            );
        }

        super.onAttach(context);
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showLoginError() {

    }
}
