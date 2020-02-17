package com.example.moviesmvc.screens.moviedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.moviesmvc.IMAGE_PATH_BASE_URL
import com.example.moviesmvc.R
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.model.MovieDetailsResponse
import kotlinx.android.synthetic.main.movies_details_fragment.view.*

class MoviesDetailsViewImpl(
    private var layoutInflater: LayoutInflater,
    private var parent : ViewGroup?
) : BaseObservableViewMvc<MovieDetailsView.Listener>(),
                            MovieDetailsView {

    override fun bindMovieDetails(movieDetailsResponse: MovieDetailsResponse) {

        getRootView().progress_bar_details.visibility = View.INVISIBLE
        getRootView().movie_container.visibility = View.VISIBLE
        Glide.with(getContext()).load(IMAGE_PATH_BASE_URL + movieDetailsResponse.poster_path).into(getRootView().movie_cover)
        getRootView().movie_budget.text = "R$${movieDetailsResponse.budget}"
        getRootView().movie_overview.text = "R$${movieDetailsResponse.overview}"
    }

    init {
        setRootView(layoutInflater.inflate(R.layout.movies_details_fragment, parent, false))
    }

}