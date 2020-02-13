package com.example.moviesmvc.screens.movieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvc.R
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.model.MovieResponse
import kotlinx.android.synthetic.main.movies_list_fragment.view.*

class MovieListViewMvcImpl(layoutInflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<MovieListViewMvc.Listener>(),
    MovieListViewMvc,
    MoviesListAdapter.Listener{

    var mAdapter = MoviesListAdapter(this)


    override fun onMovieItemClicked(movieResponse: MovieResponse) {
        getListeners().forEach {
            listener -> listener.onMovieClicked(movieResponse)
        }
    }

    init {
        setRootView(layoutInflater.inflate(R.layout.movies_list_fragment, parent, false))
        getRootView().rv_movies_list.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    override fun bindMovies(movies: List<MovieResponse>) {
        mAdapter.bindMovies(movies)
    }

    override fun showProgressIndication() {
        getRootView().progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressIndication() {
        getRootView().progress_bar.visibility = View.INVISIBLE
    }
}