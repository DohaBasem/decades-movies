package com.task.decadeofmovies.features.splash

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import com.task.base.viewModel.BaseViewModel
import io.reactivex.rxjava3.core.Completable
import java.util.concurrent.TimeUnit

class SplashVM(loggingHelper: ILoggingHelper, private val schedulerHelper: ISchedulerHelper) :
    BaseViewModel(loggingHelper, schedulerHelper) {

    private val _viewState: MutableLiveData<SplashViewState> = MutableLiveData()
    val viewState: LiveData<SplashViewState> = _viewState

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startTimer() {
        Completable.timer(2, TimeUnit.SECONDS)
            .subscribeOn(schedulerHelper.getSubscriptionScheduler())
            .observeOn(schedulerHelper.getObservationScheduler()) //TODO : Use compose along with the TransformerImpl
            .subscribe({
                _viewState.postValue(SplashViewState.SuccessState)
            },{
                _viewState.postValue(SplashViewState.ErrorState)
            })
    }
}