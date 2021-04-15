package com.task.decadeofmovies.common.utils.rx

import com.task.decadeofmovies.common.helpers.SchedulerHelper
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableSource
import io.reactivex.rxjava3.core.CompletableTransformer

class CompletableTransformerImpl(private val schedulerHelper: SchedulerHelper): CompletableTransformer {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
            .subscribeOn(schedulerHelper.getSubscriptionScheduler())
            .observeOn(schedulerHelper.getObservationScheduler())
    }
}