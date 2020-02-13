package com.example.moviesmvc.screens.movieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvc.model.MovieResponse
import com.example.moviesmvc.screens.movieslist.movielistitem.MovieListItemViewMvc
import com.example.moviesmvc.screens.movieslist.movielistitem.MovieListItemViewMvcImpl

class MoviesListAdapter(var listener: MoviesListAdapter.Listener) :
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
        movieListItemViewMvcImpl = MovieListItemViewMvcImpl(
            LayoutInflater.from(parent.context), parent
        )
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