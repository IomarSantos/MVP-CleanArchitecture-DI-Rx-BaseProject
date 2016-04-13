package com.isbx.baseproject.features.login;

import com.isbx.baseproject.data.source.LoginRepositoryComponent;
import com.isbx.baseproject.util.FragmentScoped;

import dagger.Component;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */

/**
 * This is a Dagger component. Refer to {@link com.isbx.baseproject.BaseApp} for the list of Dagger components
 * used in this application.
 * <P>
 * Because this component depends on the {@link LoginRepositoryComponent}, which is a singleton, a
 * scope must be specified. All fragment components use a custom scope for this purpose.
 */

@FragmentScoped
@Component(dependencies = LoginRepositoryComponent.class,
        modules = LoginPresenterModule.class)
public interface LoginFragmentComponent {
    LoginPresenter getLoginPresenter();
}
