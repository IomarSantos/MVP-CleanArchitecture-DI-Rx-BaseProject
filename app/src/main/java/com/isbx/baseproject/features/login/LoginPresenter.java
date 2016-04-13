package com.isbx.baseproject.features.login;

import android.support.annotation.NonNull;

import com.isbx.baseproject.data.model.AccessToken;
import com.isbx.baseproject.data.model.Account;
import com.isbx.baseproject.data.source.LoginRepository;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */

/**
 * Listens to user actions from the UI ({@link LoginFragment}), retrieves the data and
 * updates
 * the UI as required.
 * <p />
 * By marking the constructor with {@code @Inject}, Dagger injects the dependencies required to
 * create an instance of the LoginPresenter (if it fails, it emits a compiler error). It uses
 * {@link LoginPresenterModule} to do so, and the constructed instance is available in
 * {@link LoginFragmentComponent}.
 * <p/>
 * Dagger generated code doesn't require public access to the constructor or class, and
 * therefore, to ensure the developer doesn't instantiate the class manually bypassing Dagger,
 * it's good practice minimise the visibility of the class/constructor as much as possible.
 */

public class LoginPresenter implements LoginContract.UserActionsListener {

    @NonNull
    private final LoginRepository mLoginRepository;

    @NonNull
    private final LoginContract.View mLoginView;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    LoginPresenter(LoginRepository loginRepository,
                   LoginContract.View loginView) {
        mLoginRepository = loginRepository;
        mLoginView = loginView;
    }

    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    @Inject
    void setupListeners() {
        mLoginView.setUserActionListener(this);
    }

    @Override
    public void login(String email, String password) {
        mLoginView.showLoading();
        mLoginRepository.login(new Account.Builder().withEmail(email).withPassword(password).build())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(new Subscriber<AccessToken>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    mLoginView.showInvalidLoginError();
                }

                @Override
                public void onNext(AccessToken accessToken) {
                    mLoginView.showLoginSuccess();
                }
            });
    }
}