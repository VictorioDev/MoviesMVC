package com.example.moviesmvc.screens.movieslist

import com.example.moviesmvc.common.views.ObservableViewMvc
import com.example.moviesmvc.model.MovieResponse

interface MovieListViewMvc : ObservableViewMvc<MovieListViewMvc.Listener> {

    interface Listener {
        fun onMovieClicked(movie: MovieResponse)
    }

    abstract fun bindMovies(movies: List<MovieResponse>)

    abstract fun showProgressIndication()

    abstract fun hideProgressIndication()
}