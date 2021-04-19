package com.task.decadeofmovies.common.di

import com.task.base.helpers.*
import com.task.decadeofmovies.common.helpers.*
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val helpersModules = module {
    single { LoggingHelper() as ILoggingHelper }
    single { SchedulerHelper() as ISchedulerHelper }
    single { SerilizationHelper() as ISerializationHelper }
    single { SharedPreferenceHelper(context = androidContext()) as ISharedPreferenceHelper }
    single { PhotoLoadingHelper() as IPhotoLoadingHelper  }
    factory { CompositeDisposable() }
}