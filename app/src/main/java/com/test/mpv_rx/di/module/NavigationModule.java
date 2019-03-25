package com.test.mpv_rx.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.BaseRouter;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {

    private final Cicerone<Router> mCicerone;

    public NavigationModule() {
        mCicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    public Router getRouter() {
        return mCicerone.getRouter();
    }

    @Provides
    @Singleton
    public NavigatorHolder getNavigatorHolder() {
        return mCicerone.getNavigatorHolder();
    }
}
