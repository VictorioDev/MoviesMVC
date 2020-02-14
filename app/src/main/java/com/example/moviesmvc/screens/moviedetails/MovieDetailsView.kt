package com.example.moviesmvc.screens.moviedetails

import com.example.moviesmvc.common.views.ObservableViewMvc
import com.example.moviesmvc.model.MovieDetailsResponse


interface MovieDetailsView : ObservableViewMvc<MovieDetailsView.Listener> {

    interface Listener {
        fun onFavoriteClicked(movieId : String)
    }

    fun showSucessFavoriteMessage()

    fun bindMovieDetails(movieDetailsResponse: MovieDetailsResponse)

}