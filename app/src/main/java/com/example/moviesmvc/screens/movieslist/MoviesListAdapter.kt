package com.example.moviesmvc.screens.movieslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvc.common.factory.ViewMvcFactory
import com.example.moviesmvc.model.MovieResponse
import com.example.moviesmvc.screens.movieslist.movielistitem.MovieListItemViewMvc

class MoviesListAdapter(
    private var listener: MoviesListAdapter.Listener,
    private var mvcViewFactory: ViewMvcFactory) :
    RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder>(),
    MovieListItemViewMvc.Listener{

    override fun onMovieItemClick(movieResponse: MovieResponse) {
        listener.onMovieItemClicked(movieResponse)
    }

    interface Listener {
        fun onMovieItemClicked(movieResponse: MovieResponse)
    }


    private var movies = arrayListOf<MovieResponse>()
    private lateinit var movieListItemViewMvcImpl: MovieListItemViewMvc

    fun bindMovies(moviesReceived: List<MovieResponse>) {
        movies.addAll(moviesReceived)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        movieListItemViewMvcImpl = mvcViewFactory.getMoviesListItemViewMvc(parent)
        movieListItemViewMvcImpl.registerListener(this)
        return MoviesListViewHolder(movieListItemViewMvcImpl)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.movieListViewMvcImpl.bindMovie(movies[position])
    }

    data class MoviesListViewHolder(var movieListViewMvcImpl: MovieListItemViewMvc) :
        RecyclerView.ViewHolder(movieListViewMvcImpl.getRootView())
}