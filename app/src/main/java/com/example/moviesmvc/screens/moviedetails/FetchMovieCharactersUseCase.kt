package com.example.moviesmvc.screens.moviedetails



import com.example.moviesmvc.api.MoviesServiceApi
import com.example.moviesmvc.common.BaseObservable
import com.example.moviesmvc.model.MovieDestailsResponse2
import com.example.moviesmvc.model.MovieDetailsResponse
import com.example.moviesmvc.model.MovieResponse


class FetchMovieCharactersUseCase(private var mMoviesServiceApi: MoviesServiceApi) : BaseObservable<FetchMovieDetailsUseCase.Listener>() {

    interface Listener {
        fun onCharacterFetched(movie: MovieDetailsResponse)
        fun onCharacterFetchError()
    }


    fun fetchCharacterAndNotify(characterId : String){
        var movie : MovieResponse? = null
        /*mMoviesServiceApi.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    movieDetailsResponse ->
                onSuccess(movieDetailsResponse)
            },{
                Log.d("VAZP", it.message)
                onError()
            })*/

    }

    private fun onSuccess(movieResponse: MovieDestailsResponse2){
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