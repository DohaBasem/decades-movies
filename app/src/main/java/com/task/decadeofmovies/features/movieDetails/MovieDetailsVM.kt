package com.task.decadeofmovies.features.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.base.helpers.ILoggingHelper
import com.task.base.helpers.ISchedulerHelper
import com.task.base.viewModel.BaseViewModel
import com.task.decadeofmovies.common.db.entities.MovieItemEntity
import com.task.decadeofmovies.common.mappers.MovieDetailsMapper
import com.task.decadeofmovies.common.repos.interfaces.IMoviesRepo
import com.task.decadeofmovies.common.repos.interfaces.IPhotoSRepo
import com.task.decadeofmovies.common.utils.rx.addTo
import com.task.decadeofmovies.features.movieDetails.uiModels.MovieDetails
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.BiFunction
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieDetailsVM(
    loggingHelper: ILoggingHelper,
    schedulerHelpers: ISchedulerHelper,
    private val photosRepo: IPhotoSRepo,
    private val moviesRepo: IMoviesRepo
) :
    BaseViewModel(loggingHelper, schedulerHelpers), KoinComponent {

    private val compositeDisposable: CompositeDisposable by inject()

    private val _viewState: MutableLiveData<MovieDetailsViewState> =
        MutableLiveData(MovieDetailsViewState.Idle)
    val viewState: LiveData<MovieDetailsViewState> = _viewState

    fun loadMovieDetails(movieId: Int, movieName: String) {
        moviesRepo.getMovieDetails(movieId).zipWith(photosRepo.getPhotoForMovie(movieName),
            BiFunction<MovieItemEntity, List<String>, MovieDetails> { movieItem, photos ->
                return@BiFunction MovieDetailsMapper.mapToMovieDetails(movieItem, photos)
            }).subscribeOn(schedulerHelpers.getSubscriptionScheduler())
            .observeOn(schedulerHelpers.getObservationScheduler())
            .doOnSubscribe {
                _viewState.postValue(MovieDetailsViewState.Loading)
            }
            .subscribe({
                _viewState.postValue(MovieDetailsViewState.SuccessState(it))
            }, {
                _viewState.postValue(MovieDetailsViewState.ErrorState)
                loggingHelper.logMessage("photos", it.message!!)
            })
            .addTo(compositeDisposable)
    }
}