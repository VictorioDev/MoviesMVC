package com.example.moviesmvc.screens.moviedetails

import android.util.Log
import com.example.moviesmvc.api.MoviesServiceApi
import com.example.moviesmvc.common.BaseObservable
import com.example.moviesmvc.model.MovieDetailsResponse
import com.example.moviesmvc.model.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FetchMovieDetailsUseCase(private var mMoviesServiceApi: MoviesServiceApi) : BaseObservable<FetchMovieDetailsUseCase.Listener>() {

    interface Listener {
        fun onDetailsFetched(movie: MovieDetailsResponse)
        fun onDetailsFetchError()
    }


   fun fetchDetailsAndNotify(movieId : String){
       var movie : MovieResponse? = null
        mMoviesServiceApi.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieDetailsResponse ->
                onSuccess(movieDetailsResponse)
            },{
                Log.d("VAZP", it.message)
                onError()
            })

   }

    private fun onSuccess(movieResponse: MovieDetailsResponse){
        getListeners().forEach {
            listener -> listener.onDetailsFetched(movieResponse)
        }
    }

    private fun onError(){
        getListeners().forEach {
                listener -> listener.onDetailsFetchError()
        }
    }
}