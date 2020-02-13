package com.example.moviesmvc.movieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesmvc.IMAGE_PATH_BASE_URL
import com.example.moviesmvc.R
import com.example.moviesmvc.model.MovieResponse
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MoviesListAdapter(var movies: List<MovieResponse>) : RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MoviesListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bindView(position)
    }

    inner class MoviesListViewHolder(var view : View) : RecyclerView.ViewHolder(view){

        fun bindView(position : Int) {
            var movie = movies[position]
            view.movie_title.text = movie.title
            view.movie_release_date.text = movie.release_date
            Glide.with(view.context).load(
                IMAGE_PATH_BASE_URL + movie.poster_path
            ).into(view.movie_cover)
        }
    }
}