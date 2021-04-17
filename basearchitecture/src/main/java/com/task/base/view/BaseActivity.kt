package com.task.base.view

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.task.base.viewModel.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel>(@LayoutRes private val layoutRes: Int) :
    AppCompatActivity() {

    val viewModel by lazy {
        initViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        lifecycle.addObserver(viewModel)
        initObservers()
    }

    abstract fun initViewModel(): VM

    abstract fun initObservers()

    fun showError(error: String) {
        Toast.makeText(baseContext,error,LENGTH_LONG).show()
    }
}