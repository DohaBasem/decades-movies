package com.task.decadeofmovies.features.searchMovies.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.task.base.view.BaseFragment
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.searchMovies.MoviesViewState
import com.task.decadeofmovies.features.searchMovies.SearchMoviesVM
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SearchFragment : BaseFragment<SearchMoviesVM>(R.layout.fragment_search) {

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
                is MoviesViewState.LoadedWithPayLoad -> {
                    moviesAdapter.submitList(viewState.list)
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
        return MoviesAdapter()
    }

}