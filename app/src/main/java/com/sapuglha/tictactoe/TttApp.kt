package com.sapuglha.tictactoe

import android.app.Application
import android.os.StrictMode
import com.sapuglha.tictactoe.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class TttApp : Application(), HasAndroidInjector {
    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this);

        initialize()
    }

    private fun initialize() {

        if (BuildConfig.DEBUG) {
            // strict mode for dev debug versions
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls()
//                    .detectDiskReads() // incompatible with dataBinding
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedClosableObjects()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedRegistrationObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
        }
    }
}
