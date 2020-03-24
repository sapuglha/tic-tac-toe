package com.sapuglha.tictactoe

import android.app.Application
import android.os.StrictMode
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.sapuglha.tictactoe.di.DaggerAppComponent
import com.sapuglha.tictactoe.error.CrashlyticsReportingTree
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject


class TttApp : Application(), HasAndroidInjector {
    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        setupLogging()

        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this);

        initialize()
    }

    private fun setupLogging() {
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashlyticsReportingTree())

        // Disable Crashlytics for debug builds
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
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
