package com.task.base.helpers

import io.reactivex.rxjava3.core.Scheduler


interface ISchedulerHelper {
    fun getSubscriptionScheduler(): Scheduler
    fun getObservationScheduler(): Scheduler
    fun getTrampolineScheduler(): Scheduler
}