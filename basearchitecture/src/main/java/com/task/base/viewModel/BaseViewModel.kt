package com.task.base.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val loggingHelper: ILoggingHelper,
    protected val schedulerHelpers: ISchedulerHelper
) : ViewModel(), LifecycleObserver