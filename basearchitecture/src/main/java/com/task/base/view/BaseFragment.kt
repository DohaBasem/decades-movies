package com.task.base.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.task.base.viewModel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes private val layoutRes: Int) :
    Fragment(layoutRes) {

    val viewModel:VM by lazy { initViewModel() }

    abstract fun initViewModel(): VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        initObservers()
    }

    fun showError(error: String) {
        Toast.makeText(context,error, Toast.LENGTH_LONG).show()
    }

    abstract fun initObservers()

}