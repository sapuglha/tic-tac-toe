package com.sapuglha.tictactoe.di;

import android.app.Application;

import com.sapuglha.tictactoe.TttApp;
import com.sapuglha.tictactoe.controller.GameStatusHandler;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    void inject(TttApp app);
}
