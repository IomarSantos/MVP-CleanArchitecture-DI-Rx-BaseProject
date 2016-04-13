package com.isbx.baseproject.data.source;

import com.isbx.baseproject.ApplicationModule;
import com.isbx.baseproject.features.login.LoginActivity;
import com.isbx.baseproject.features.login.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */


@Singleton
@Component(modules = {LoginRepositoryModule.class, ApplicationModule.class})
public interface LoginRepositoryComponent {

    void inject(LoginActivity loginActivity);
    void inject(LoginFragment loginFragment);

    LoginRepository getLoginRepository();
}
