package com.isbx.baseproject.data.source;

import com.isbx.baseproject.data.model.AccessToken;
import com.isbx.baseproject.data.model.Account;
import com.isbx.baseproject.data.source.remote.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */

@Singleton
public class LoginRepository {
    private final LoginService loginService;

    @Inject
    LoginRepository(@Remote LoginService loginService) {
        this.loginService = loginService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public Observable<AccessToken> login(Account account) {
        return loginService.login(account);
    }
}
