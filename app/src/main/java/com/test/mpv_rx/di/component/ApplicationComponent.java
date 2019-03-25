package com.test.mpv_rx.di.component;

import com.test.mpv_rx.activity.MainActivity;
import com.test.mpv_rx.di.module.ApplicationModule;
import com.test.mpv_rx.di.module.NavigationModule;
import com.test.mpv_rx.fragment.Fragment1;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NavigationModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(Fragment1 fragment1);

}
