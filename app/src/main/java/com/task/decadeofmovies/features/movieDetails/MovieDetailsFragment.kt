package com.task.decadeofmovies.features.movieDetails

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.task.base.view.BaseFragment
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.movieDetails.interfaces.MovieDetailsViewContract
import com.task.decadeofmovies.features.movieDetails.uiModels.MovieDetails
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailsFragment(layoutRes: Int = R.layout.fragment_movie_details) : BaseFragment<MovieDetailsVM>(layoutRes), MovieDetailsViewContract {

    private val args:MovieDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadMovieDetails(args.movieId,args.movieName)
    }

    override fun initViewModel(): MovieDetailsVM {
        return getViewModel()
    }

    override fun initObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            when(viewState){
                is MovieDetailsViewState.Idle,MovieDetailsViewState.Loading -> {
                    showLoadingDetails()
                }
                is MovieDetailsViewState.SuccessState -> {
                    showDetails(viewState.movieDetails)
                }
                is MovieDetailsViewState.ErrorState ->{
                    showErrorLoadingDetails()
                }
            }
        })
    }

    override fun showLoadingDetails() {

    }

    override fun showDetails(movieDetails: MovieDetails) {
    }

    override fun showErrorLoadingDetails() {
    }
}