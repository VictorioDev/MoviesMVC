package com.example.moviesmvc.screens.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviesmvc.common.fragment.BaseFragment

class MoviesListFragment : BaseFragment() {


    lateinit var mViewMvc: MovieListViewMvc
    lateinit var mController: MoviesListController

    companion object {
        fun getInstance() = MoviesListFragment()

        fun getName() = "FRAGMENT_LIST"
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewMvc = getControllerDependencyManager().getViewMvcFactory().getMoviesListViewMvc(container)

        mViewMvc.registerListener(activity as MovieListViewMvc.Listener)
        mController = getControllerDependencyManager().getMoviesListController()
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
        mViewMvc.unregisterListener(activity as MovieListViewMvc.Listener)
    }



}