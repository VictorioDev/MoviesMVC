package com.example.moviesmvc.movieslist

import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvc.R
import com.example.moviesmvc.api.MoviesServiceApi
import com.example.moviesmvc.model.MovieResponse
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.movies_list_fragment.*

class MoviesListFragment : Fragment() {

    private var moviesList = arrayListOf<MovieResponse>()
    private var mAdapter : MoviesListAdapter = MoviesListAdapter(moviesList)



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.movies_list_fragment, null, false)
        return view
    }

    override fun onStart() {
        super.onStart()

        rv_movies_list.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }


    }

    private fun fetchMovies(){
        var movieServiceApi = MoviesServiceApi.getInstance()

        movieServiceApi.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieResponse ->
                moviesList.addAll(movieResponse.movieResponses)
                mAdapter.notifyDataSetChanged()
            },{
                t ->
                Log.d("VAZP", t.message)
            })

    }
}