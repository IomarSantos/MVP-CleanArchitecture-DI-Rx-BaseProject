package com.isbx.baseproject.data.source;

import android.content.Context;

import com.isbx.baseproject.data.source.remote.LoginService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */
@Module
public class LoginRepositoryModule {
    private Context context;

    public LoginRepositoryModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    LoginRepository provideLoginRepository() {
        return new LoginRepository(LoginService.Factory.makeLoginService(context));
    }
}
