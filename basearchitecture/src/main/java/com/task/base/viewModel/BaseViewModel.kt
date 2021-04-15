package com.task.base.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper

abstract class BaseViewModel(
    private val loggingHelper: ILoggingHelper,
    private val schedulerHelpers: ISchedulerHelper
) : ViewModel(), LifecycleObserver