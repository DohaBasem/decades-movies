package com.task.base.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.task.base.viewModel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes private val layoutRes: Int) :
    Fragment(layoutRes) {

    val viewModel:VM by lazy { initViewModel() }

    abstract fun initViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }
}