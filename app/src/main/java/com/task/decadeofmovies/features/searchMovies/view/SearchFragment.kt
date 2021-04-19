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
import com.task.decadeofmovies.features.searchMovies.view.interfaces.YearItemClickListener
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.layout_movies_listing_loaded.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SearchFragment : BaseFragment<SearchMoviesVM>(R.layout.fragment_search), MovieListingContract {

    private val moviesAdapter by lazy { initMoviesAdapter() }
    private val yearsAdapter by lazy { initYearsAdapter() }

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
            yearsAdapter.submitList(it)
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

    private fun initYearsAdapter():YearsAdapter{
        val itemClickListener = object : YearItemClickListener{
            override fun onYearClicked(year: String, itemPosition: Int) {
                handleYearSelection(year,itemPosition)
            }
        }
        return YearsAdapter(itemClickListener = itemClickListener)
    }

    override fun showMoviesLoading() {
        vf_movies_listing.displayedChild = LOADING_VIEW
    }

    override fun showAllMovies(movies: List<Movie>) {
        vf_movies_listing.displayedChild = LOADED_VIEW
        moviesAdapter.submitList(movies)
    }

    override fun showErrorLoadingMovies() {
        vf_movies_listing.displayedChild = ERROR_VIEW
    }

    override fun showNoMoviesAvailable() {
        vf_movies_listing.displayedChild = EMPTY_VIEW
    }

    override fun handleYearSelection(year: String, itemPosition: Int) {
        tv_year_lbl.text = year
        yearsAdapter.selectItem(itemPosition)
        viewModel.filterMoviesByYear(year)
    }

    /*I used the view flipper to easily switch between views according to the view state
   Why I like this appraoch :
     Removes the hassle of adding everything inside a single layout and setting the components visibility
     Makes it easier to design complex layouts for different states (loading, error, empty ,...) that could be
     reused in difeerent screens
    */
    companion object MainViewFlipperIndices{
        const val LOADING_VIEW = 0
        const val LOADED_VIEW = 1
        const val EMPTY_VIEW = 2
        const val ERROR_VIEW = 3
    }
}