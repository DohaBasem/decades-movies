package com.task.base.view

import android.os.Bundle
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
    }

    abstract fun initViewModel(): VM

    fun showError(error: String) {
        Snackbar.make(findViewById(android.R.id.content), error, Snackbar.LENGTH_LONG).show()
    }
}