package com.task.decadeofmovies.common.di

import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import com.task.decadeofmovies.common.helpers.LoggingHelper
import com.task.decadeofmovies.common.helpers.SchedulerHelper
import com.task.decadeofmovies.common.utils.rx.ObservableTransformerImpl
import io.reactivex.rxjava3.core.ObservableTransformer
import org.koin.dsl.module

val helpersModules = module {
    single { LoggingHelper() as ILoggingHelper }
    single { SchedulerHelper() as ISchedulerHelper }
}