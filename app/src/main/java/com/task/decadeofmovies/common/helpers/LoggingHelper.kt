package com.task.decadeofmovies.common.helpers

import android.util.Log
import com.task.base.helpers.ILoggingHelper
import com.task.decadeofmovies.BuildConfig

class LoggingHelper: ILoggingHelper {

    //This is done as an implementation to the interface to give the developer the flexibility to use
    //any logging implementation(it could be something like the default android logging or Timber)
   override fun logMessage(tag: String, message: String){
        if(BuildConfig.DEBUG){
            Log.d(tag,message)
        } else {
            //This could be logging to crashlytics
        }

    }
}