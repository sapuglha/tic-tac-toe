package com.sapuglha.tictactoe.di

import android.app.Application
import com.sapuglha.tictactoe.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [
    (AndroidInjectionModule::class),
    (AppModule::class),
    (ActivityBuilder::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
