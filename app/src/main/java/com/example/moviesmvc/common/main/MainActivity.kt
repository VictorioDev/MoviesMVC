package com.example.moviesmvc.common.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.moviesmvc.R
import com.example.moviesmvc.common.fragment.FragmentFrameHelper
import com.example.moviesmvc.common.views.ViewMvc
import com.example.moviesmvc.model.MovieResponse
import com.example.moviesmvc.screens.moviedetails.MovieDetailsFragment
import com.example.moviesmvc.screens.movieslist.MovieListViewMvc
import com.example.moviesmvc.screens.movieslist.MoviesListFragment

class MainActivity : AppCompatActivity(), MovieListViewMvc.Listener {



    lateinit var mFragmentFrameHelper : FragmentFrameHelper

    override fun onMovieClicked(movie: MovieResponse) {
        mFragmentFrameHelper.replaceFragment(MovieDetailsFragment.getInstance(movie.id.toString()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mViewMvc : MainViewMvc = MainViewMvcImpl(layoutInflater)
        mFragmentFrameHelper = FragmentFrameHelper(mViewMvc, supportFragmentManager)
        setContentView(mViewMvc.getRootView())
        if(savedInstanceState == null){
            mFragmentFrameHelper.replaceFragment(MoviesListFragment.getInstance())
        }

    }
}
