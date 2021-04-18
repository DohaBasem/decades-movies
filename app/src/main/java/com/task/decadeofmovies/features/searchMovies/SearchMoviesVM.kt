package com.task.decadeofmovies.features.searchMovies

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import com.task.base.viewModel.BaseViewModel
import com.task.decadeofmovies.common.mappers.SuccessViewStateMapper
import com.task.decadeofmovies.common.repos.interfaces.IMoviesRepo
import com.task.decadeofmovies.common.utils.rx.addTo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject

class SearchMoviesVM(
    loggingHelper: ILoggingHelper,
    schedulerHelpers: ISchedulerHelper,
    private val moviesRepo: IMoviesRepo
) :
    BaseViewModel(loggingHelper, schedulerHelpers), KoinComponent {

    private val compositeDisposable: CompositeDisposable by inject()

    private val _moviesViewState: MutableLiveData<MoviesViewState> =
        MutableLiveData(MoviesViewState.Idle)
    val moviesViewState: LiveData<MoviesViewState> = _moviesViewState

    val moviesYears: LiveData<List<String>> = moviesRepo.fetchMoviesDistinctYears()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getAllMovies() {
        moviesRepo.fetchAllMovies()
            .map {
                SuccessViewStateMapper.map(it,MoviesViewState::class.java)
            }
            .subscribeOn(schedulerHelpers.getSubscriptionScheduler())
            .observeOn(schedulerHelpers.getObservationScheduler())
            .subscribe({
                successfulViewState ->
                loggingHelper.logMessage("movies", "fetched successfully")
                _moviesViewState.postValue(successfulViewState)
            }, {
                loggingHelper.logMessage("movies", "failed to fetch movies bacause ${it.message}")
                _moviesViewState.postValue(MoviesViewState.GenericError)
            }).addTo(compositeDisposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}