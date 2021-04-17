package com.task.decadeofmovies.common.di

import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import com.task.base.helpers.ISerializationHelper
import com.task.base.helpers.ISharedPreferenceHelper
import com.task.decadeofmovies.common.helpers.LoggingHelper
import com.task.decadeofmovies.common.helpers.SchedulerHelper
import com.task.decadeofmovies.common.helpers.SerilizationHelper
import com.task.decadeofmovies.common.helpers.SharedPreferenceHelper
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val helpersModules = module {
    single { LoggingHelper() as ILoggingHelper }
    single { SchedulerHelper() as ISchedulerHelper }
    single { SerilizationHelper() as ISerializationHelper }
    single { SharedPreferenceHelper(context = androidContext()) as ISharedPreferenceHelper }
    factory { CompositeDisposable() }
}