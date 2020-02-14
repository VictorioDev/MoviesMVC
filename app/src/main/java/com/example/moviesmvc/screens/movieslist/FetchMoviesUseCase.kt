package com.example.moviesmvc.screens.movieslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesmvc.api.MoviesServiceApi
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.common.views.ObservableViewMvc
import com.example.moviesmvc.model.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FetchMoviesUseCase(var movieServiceApi: MoviesServiceApi) : BaseObservableViewMvc<FetchMoviesUseCase.Listener>(){

    interface Listener{
        fun onMoviesFetched(movies : List<MovieResponse>)
        fun onMoviesFetchedFailed()
    }

    fun fetchMoviesAndNotify(){
        var movies = arrayListOf<MovieResponse>()
        movieServiceApi.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    movieResponse ->
                movieResponse.let {
                    movies.addAll(movieResponse.results)
                    getListeners().forEach {
                        listener -> listener.onMoviesFetched(movies)
                    }
                }
            },{
                    t ->
                Log.d("VAZP", t.message)
                getListeners().forEach {
                    listener -> listener.onMoviesFetchedFailed()
                }
            })

    }


}