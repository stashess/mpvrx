package com.test.mpv_rx;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.test.mpv_rx.di.component.ApplicationComponent;
import com.test.mpv_rx.di.component.DaggerApplicationComponent;
import com.test.mpv_rx.di.module.ApplicationModule;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import timber.log.Timber;

public class RxApp extends Application {
    public static RxApp INSTANCE;
    private Cicerone<Router> mCicerone;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initCicerone();
        Timber.plant(new Timber.DebugTree());
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }

    private void initCicerone() {
        mCicerone = Cicerone.create();
    }

    public NavigatorHolder getNavigationHolder(){
        return mCicerone.getNavigatorHolder();
    }

    public Router getRouter(){
        return mCicerone.getRouter();
    }
}
