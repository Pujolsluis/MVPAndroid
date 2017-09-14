package com.example.devs.mvplogin.login;

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
import android.widget.Toast;

import com.example.devs.mvplogin.R;

import static com.example.devs.mvplogin.R.layout.fragment_login;

public class LoginFragment extends Fragment {

    onLoginButtonClickListener mCallback;
    EditText email;
    EditText password;
    Button loginButton;

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

        View rootView = inflater.inflate(fragment_login, container);
        email = rootView.findViewById(R.id.login_email_textView);
        password = rootView.findViewById(R.id.login_password_textView);
        loginButton = rootView.findViewById(R.id.login_buttonView);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(getContext(), "You must complete all fields", Toast.LENGTH_SHORT).show();
                }else{
                    mCallback.onLoginClicked();
                }

            }
        });


        return rootView;

    }

    @Override
    public void onAttach(Context context) {

        try {

            mCallback = (onLoginButtonClickListener) context;

        }catch (ClassCastException e){

            throw new ClassCastException(context.toString()
                    + " must implement onLoginButtonClickListener"
            );

        }

        super.onAttach(context);
    }

    public interface onLoginButtonClickListener{
            void onLoginClicked();
    }

}
