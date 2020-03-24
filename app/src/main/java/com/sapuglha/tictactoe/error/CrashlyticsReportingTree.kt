package com.sapuglha.tictactoe.error

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class CrashlyticsReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        if (priority in listOf(Log.VERBOSE, Log.DEBUG, Log.INFO)) {
            return
        }

        if (throwable != null) {
            FirebaseCrashlytics.getInstance().recordException(throwable)
        } else {
            FirebaseCrashlytics.getInstance().log(message)
        }
    }
}
