package com.example.moviesmvc.screens.moviedetails

import android.widget.Toast
import com.example.moviesmvc.model.MovieDestailsResponse2
import com.example.moviesmvc.model.MovieDetailsResponse

class MovieDetailsController(private var fetchMovieDetailsUseCase: FetchMovieDetailsUseCase): MovieDetailsView.Listener,
FetchMovieDetailsUseCase.Listener{

    private lateinit var mViewMvc : MovieDetailsView

    override fun onDetailsFetched(movie: MovieDestailsResponse2) {
        mViewMvc.bindMovieDetails(movie)
    }

    override fun onDetailsFetchError() {
        Toast.makeText(mViewMvc.getRootView().context, "ERRO AO CARREGAR DETALHES", Toast.LENGTH_SHORT).show()
    }

    override fun onFavoriteClicked(movieId: String) {
        TODO()
    }



    fun onStart(movieId : String){
        mViewMvc.registerListener(this)
        fetchMovieDetailsUseCase.registerListener(this)
        fetchMovieDetailsUseCase.fetchDetailsAndNotify(movieId)
    }

    fun onStop(){
        mViewMvc.unregisterListener(this)
    }

    fun bindView(movieViewMvc : MovieDetailsView){
        mViewMvc = movieViewMvc
    }
}