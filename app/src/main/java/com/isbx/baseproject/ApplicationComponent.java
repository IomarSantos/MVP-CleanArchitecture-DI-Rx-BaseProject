package com.isbx.baseproject;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrewconcepcion on 15/02/2016.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApp baseApp);
//    void inject(RegistrationIntentService registrationIntentService);

    @ApplicationContext Context context();
    Application application();
//    LoginService loginService();
//    PreferencesHelper preferencesHelper();
//    LoginRepository loginRepository();

}
