package com.example.moviesmvc.screens.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MoviesListFragment : Fragment() {

    lateinit var mViewMvc: MovieListViewMvc
    lateinit var mController: MoviesListController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewMvc = MovieListViewMvcImpl(LayoutInflater.from(context), container)
        mController = MoviesListController()
        mController.bindView(mViewMvc)
        return mViewMvc.getRootView()
    }

    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }


}