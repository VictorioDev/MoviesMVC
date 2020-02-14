package com.example.moviesmvc.screens.movieslist

import android.widget.Toast
import com.example.moviesmvc.common.fragment.FragmentFrameHelper
import com.example.moviesmvc.model.MovieResponse
import com.example.moviesmvc.screens.movieslist.FetchMoviesUseCase
import com.example.moviesmvc.screens.movieslist.MovieListViewMvc

class MoviesListController(
    private var fetchMoviesUseCase : FetchMoviesUseCase
    ) : MovieListViewMvc.Listener, FetchMoviesUseCase.Listener {


    override fun onMoviesFetched(movies: List<MovieResponse>) {
        mViewMvc.hideProgressIndication()
        mViewMvc.bindMovies(movies)
    }

    override fun onMoviesFetchedFailed() {
        Toast.makeText(mViewMvc.getRootView().context, "ERRO AO CARREGAR FILMES", Toast.LENGTH_SHORT).show()
    }

    lateinit var mViewMvc : MovieListViewMvc

    override fun onMovieClicked(movie: MovieResponse) {
        Toast.makeText(mViewMvc.getRootView().context, movie.title, Toast.LENGTH_SHORT).show()
    }

    fun bindView(view : MovieListViewMvc){
        mViewMvc = view
    }

    fun onStart(){
        mViewMvc.registerListener(this)
        fetchMoviesUseCase.registerListener(this)
        fetchMoviesUseCase.fetchMoviesAndNotify()
    }

    fun onStop(){
        mViewMvc.unregisterListener(this)
        fetchMoviesUseCase.unregisterListener(this)
    }
}