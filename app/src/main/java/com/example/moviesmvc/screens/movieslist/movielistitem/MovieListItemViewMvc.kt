package com.example.moviesmvc.screens.movieslist.movielistitem

import com.example.moviesmvc.common.views.ObservableViewMvc
import com.example.moviesmvc.model.MovieResponse

interface MovieListItemViewMvc : ObservableViewMvc<MovieListItemViewMvc.Listener> {

    interface Listener {
        fun onMovieItemClick(movieResponse : MovieResponse)
    }


    fun bindMovie(movieResponse: MovieResponse)
}