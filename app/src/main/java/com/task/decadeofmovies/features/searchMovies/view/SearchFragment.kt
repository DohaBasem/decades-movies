package com.task.decadeofmovies.features.searchMovies.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.task.base.view.BaseFragment
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.searchMovies.MoviesViewState
import com.task.decadeofmovies.features.searchMovies.SearchMoviesVM
import com.task.decadeofmovies.features.searchMovies.uiModels.Movie
import com.task.decadeofmovies.features.searchMovies.view.adapters.MoviesAdapter
import com.task.decadeofmovies.features.searchMovies.view.adapters.YearsAdapter
import com.task.decadeofmovies.features.searchMovies.view.interfaces.MovieItemClickListener
import com.task.decadeofmovies.features.searchMovies.view.interfaces.MovieListingContract
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SearchFragment : BaseFragment<SearchMoviesVM>(R.layout.fragment_search), MovieListingContract {

    private val moviesAdapter by lazy { initMoviesAdapter() }
    private val yearsAdapter by lazy { YearsAdapter() }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initViewModel(): SearchMoviesVM = getViewModel()


    override fun initObservers() {
        viewModel.moviesViewState.observe(viewLifecycleOwner, Observer { viewState ->
            when (viewState) {
                is MoviesViewState.Loading, MoviesViewState.Idle -> {
                    showMoviesLoading()
                }
                is MoviesViewState.LoadedWithPayLoad -> {
                    showAllMovies(viewState.list)
                }
                is MoviesViewState.GenericError -> {
                    showErrorLoadingMovies()
                }
                MoviesViewState.LoadedWithEmptyPayLoad -> {
                    showNoMoviesAvailable()
                }
            }
        })
        viewModel.moviesYears.observe(viewLifecycleOwner, Observer {
            yearsAdapter.setItems(it)
        })
    }

    private fun initView() {
        rv_movies.adapter = moviesAdapter
        rv_years.adapter = yearsAdapter
    }

    private fun initMoviesAdapter(): MoviesAdapter {
        val clickListener = object :
            MovieItemClickListener {
            override fun onMovieClicked(movieId: Int, movieName: String) {
                findNavController().navigate(SearchFragmentDirections.actionFromMovieListingToDetails(movieId,movieName))
            }
        }
        return MoviesAdapter(
            clickListener
        )
    }

    override fun showMoviesLoading() {
    }

    override fun showAllMovies(movies: List<Movie>) {

    }

    override fun showErrorLoadingMovies() {
    }

    override fun showNoMoviesAvailable() {
    }

}