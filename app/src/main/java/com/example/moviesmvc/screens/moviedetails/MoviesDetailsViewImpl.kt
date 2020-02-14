package com.example.moviesmvc.screens.moviedetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesmvc.R
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.model.MovieDetailsResponse

class MoviesDetailsViewImpl(
    private var layoutInflater: LayoutInflater,
    private var parent : ViewGroup?
) : BaseObservableViewMvc<MovieDetailsView.Listener>(),
                            MovieDetailsView {

    override fun bindMovieDetails(movieDetailsResponse: MovieDetailsResponse) {

    }

    init {
        setRootView(layoutInflater.inflate(R.layout.movies_details_fragment, parent, false))
    }

    override fun showSucessFavoriteMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}