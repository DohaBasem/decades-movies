package com.task.decadeofmovies.common.helpers

import com.task.base.helpers.ISchedulerHelper
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class SchedulerHelper: ISchedulerHelper {
    override fun getObservationScheduler(): Scheduler {
        return Schedulers.newThread()
    }

    override fun getSubscriptionScheduler(): Scheduler {
        return Schedulers.newThread()
    }

    override fun getTrampolineScheduler(): Scheduler {
        return Schedulers.trampoline()
    }
}