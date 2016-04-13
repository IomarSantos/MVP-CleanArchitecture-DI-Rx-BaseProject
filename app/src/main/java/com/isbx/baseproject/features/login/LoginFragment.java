package com.isbx.baseproject.features.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dd.CircularProgressButton;
import com.isbx.baseproject.R;
import com.isbx.baseproject.data.source.DaggerLoginRepositoryComponent;
import com.isbx.baseproject.data.source.LoginRepositoryComponent;
import com.isbx.baseproject.data.source.LoginRepositoryModule;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main UI for the login screen. Users can enter a username and password.
 */

public class LoginFragment extends Fragment implements LoginContract.View {
    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.btnLogin)
    CircularProgressButton btnLogin;
    private LoginRepositoryComponent mLoginRepositoryComponent;
    private LoginPresenter mActionListener;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    public LoginFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLoginRepositoryComponent = DaggerLoginRepositoryComponent.builder()
//                .applicationModule(new ApplicationModule((Application) getActivity().getApplicationContext()))
                .loginRepositoryModule(new LoginRepositoryModule(getActivity()))
                .build();
        mLoginRepositoryComponent.inject(this);

        LoginFragmentComponent featureComponent = DaggerLoginFragmentComponent.builder()
                .loginPresenterModule(new LoginPresenterModule(this))
                .loginRepositoryComponent(mLoginRepositoryComponent)
                .build();
        mActionListener = featureComponent.getLoginPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_frag, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showInvalidLoginError() {
        btnLogin.setProgress(-1);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnLogin.setProgress(0);
            }
        }, 1500);
    }

    @Override
    public void showLoginSuccess() {
        btnLogin.setProgress(100);
    }

    @Override
    public void setUserActionListener(LoginContract.UserActionsListener listener) {
//        mActionListener = listener;
    }

    @Override
    public void showLoading() {
        btnLogin.setIndeterminateProgressMode(true);
        btnLogin.setProgress(50);
    }

    @Override
    public void hideLoading() {
        btnLogin.setProgress(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClick() {
        mActionListener.login(email.getText().toString(), password.getText().toString());
    }
}
