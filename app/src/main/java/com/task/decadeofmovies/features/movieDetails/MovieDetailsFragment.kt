package com.task.decadeofmovies.features.movieDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.task.base.helpers.ILoggingHelper
import com.task.base.view.BaseFragment
import com.task.decadeofmovies.R
import com.task.decadeofmovies.features.movieDetails.adapters.*
import com.task.decadeofmovies.features.movieDetails.interfaces.MovieDetailsViewContract
import com.task.decadeofmovies.features.movieDetails.uiModels.MovieDetails
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailsFragment(layoutRes: Int = R.layout.fragment_movie_details) :
    BaseFragment<MovieDetailsVM>(layoutRes), MovieDetailsViewContract {

    private val args: MovieDetailsFragmentArgs by navArgs()
    private val imagesAdapter by lazy { ImagesAdapter() }
    private val castAdapter by lazy { CastAdapter() }
    private val genereAdapter by lazy { GenereAdapter() }
    private val movieGeneralDetailsAdapter by lazy { TextAdapter(TextType.SIMPLE_TEXT) }
    /*The concat adapter is used here to show all the details in a single recyclerview, instead of adding
    multiple recyclerviews and setting the recyclerview to wrap content loosing the recycling views functionality
    * */
    private val mainAdapter =
        ConcatAdapter(movieGeneralDetailsAdapter, castAdapter, genereAdapter, imagesAdapter)

    private val loggerHelper: ILoggingHelper by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadMovieDetails(args.movieId, args.movieName)
        initView()
    }

    private fun initView() {
        val layoutManager = GridLayoutManager(context, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                loggerHelper.logMessage("itemViewType","viewType ${mainAdapter.getItemViewType(position)} for pos ${position}")
                return when (mainAdapter.getItemViewType(position)) {
                    0,2 -> 2
                    else -> 1
                }
            }
        }
        rv_images.layoutManager = layoutManager
        rv_images.adapter = mainAdapter
    }

    override fun initViewModel(): MovieDetailsVM {
        return getViewModel()
    }

    override fun initObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            when (viewState) {
                is MovieDetailsViewState.Idle, MovieDetailsViewState.Loading -> {
                    showLoadingDetails()
                }
                is MovieDetailsViewState.SuccessState -> {
                    showDetails(viewState.movieDetails)
                }
                is MovieDetailsViewState.ErrorState -> {
                    showErrorLoadingDetails()
                }
            }
        })
    }

    override fun showLoadingDetails() {
        vf_movie_details.displayedChild = LOADING_VIEW
    }

    override fun showDetails(movieDetails: MovieDetails) {
        vf_movie_details.displayedChild = LOADED_VIEW
        movieDetails.run {
            movieGeneralDetailsAdapter.submitList(listOf(String.format(getString(R.string.format_details_format),title,rating,year)))
            imagesAdapter.submitList(photos)
            castAdapter.submitList(cast)
            genereAdapter.submitList(generes)
        }

    }

    override fun showErrorLoadingDetails() {
        vf_movie_details.displayedChild = ERROR_VIEW
    }

    companion object MainViewFlipperIndices{
        const val LOADING_VIEW = 0
        const val LOADED_VIEW = 1
        const val ERROR_VIEW = 2
    }
}