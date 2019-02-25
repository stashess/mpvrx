package com.test.mpv_rx.di.component;

import com.test.mpv_rx.di.module.ApplicationModule;
import com.test.mpv_rx.di.module.NavigationModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class, NavigationModule.class})
public interface ApplicationComponent {

}
