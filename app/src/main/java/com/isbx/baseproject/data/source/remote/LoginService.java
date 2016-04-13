package com.isbx.baseproject.data.source.remote;

import android.content.Context;

import com.isbx.baseproject.BuildConfig;
import com.isbx.baseproject.data.model.AccessToken;
import com.isbx.baseproject.data.model.Account;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by andrewconcepcion on 12/04/2016.
 */
public interface LoginService {

    String ENDPOINT = "http://10.0.1.194:3000/api/";

    @POST("Accounts/login")
    Observable<AccessToken> login(@Body Account account);

    class Factory {

        public static LoginService makeLoginService(Context context) {
            OkHttpClient okHttpClient = new OkHttpClient();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);
//            okHttpClient.interceptors().add(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(LoginService.ENDPOINT)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(LoginService.class);
        }
    }
}
