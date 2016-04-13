package com.isbx.baseproject.features.login;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */

/**
 * This specifies the contract between the view and the presenter.
 */

public class LoginContract {

    interface View {

        void showInvalidLoginError();

        void showLoginSuccess();

        void setUserActionListener(UserActionsListener listener);

        void showLoading();

        void hideLoading();
    }

    interface UserActionsListener {

        void login(String email, String password);

    }
}
