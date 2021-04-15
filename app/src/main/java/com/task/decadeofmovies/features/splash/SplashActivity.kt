package com.task.decadeofmovies.features.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import com.task.base.view.BaseActivity
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashActivity(layoutRes: Int = R.layout.activity_splash) :
    BaseActivity<SplashVM>(layoutRes), SplashViewContract {

    override fun initViewModel(): SplashVM {
        return getViewModel()
    }

    override fun initObservers() {
        viewModel.viewState.observe(this, Observer { viewState ->
            when (viewState) {
                is SplashViewState.SuccessState -> {
                    navigateToMainScreen()
                }
                is SplashViewState.ErrorState -> {
                    showErrorOccured()
                }
            }
        })
    }

    override fun navigateToMainScreen() {
        MainActivity.start(this)
    }

    override fun showErrorOccured() {
        showError(getString(R.string.msg_error))
    }
}