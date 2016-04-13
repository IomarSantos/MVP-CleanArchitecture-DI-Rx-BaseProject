package com.isbx.baseproject.features.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link LoginPresenter}.
 */

@Module
public class LoginPresenterModule {

    private final LoginContract.View mView;

    public LoginPresenterModule(LoginContract.View view) {
        mView = view;
    }
    @Provides
    LoginContract.View provideLoginContractView() {
        return mView;
    }
}
