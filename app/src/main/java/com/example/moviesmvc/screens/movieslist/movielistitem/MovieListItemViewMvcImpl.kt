package com.example.moviesmvc.screens.movieslist.movielistitem

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.moviesmvc.IMAGE_PATH_BASE_URL
import com.example.moviesmvc.R
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.model.MovieResponse
import com.example.moviesmvc.screens.movieslist.MoviesListAdapter
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieListItemViewMvcImpl(layoutInflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<MovieListItemViewMvc.Listener>(),
    MovieListItemViewMvc {

    private lateinit var movieItem: MovieResponse

    init {
        setRootView(layoutInflater.inflate(R.layout.movie_list_item, parent, false))
        getRootView().setOnClickListener {
            getListeners().forEach { listener ->
                listener.onMovieItemClick(movieItem)
            }
        }
    }

    override fun bindMovie(movieResponse: MovieResponse) {
        movieItem = movieResponse
        getRootView().movie_title.text = movieItem.title
        getRootView().movie_release_date.text = movieItem.release_date
        var imageUrl = IMAGE_PATH_BASE_URL + movieItem.poster_path
        Log.d("VAZP", imageUrl)
        Glide.with(getContext())
            .load(imageUrl)
            .fitCenter()
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(getRootView().movie_cover)

    }
}