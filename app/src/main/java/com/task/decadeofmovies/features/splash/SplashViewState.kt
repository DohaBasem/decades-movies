package com.task.decadeofmovies.features.splash

sealed class SplashViewState {
    object ErrorState: SplashViewState()
    object SuccessState: SplashViewState()
}