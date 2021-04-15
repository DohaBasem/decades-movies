package com.task.decadeofmovies.common.utils.rx

import com.task.base.helpers.ISchedulerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer

class ObservableTransformerImpl<T>(val schedulerHelper: ISchedulerHelper) :
    ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .subscribeOn(schedulerHelper.getSubscriptionScheduler())
            .observeOn(schedulerHelper.getObservationScheduler())
    }
}