package com.example.moviesmvc.common.dependencyinjection

import androidx.fragment.app.FragmentActivity
import com.example.moviesmvc.common.factory.ViewMvcFactory
import com.example.moviesmvc.common.fragment.FragmentFrameHelper
import com.example.moviesmvc.common.main.MainViewMvc
import com.example.moviesmvc.screens.movieslist.FetchMoviesUseCase
import com.example.moviesmvc.screens.movieslist.MoviesListController

class ControllerDependencyManager(
    val mGlobalDependencyManager: GlobalDependencyManager,
    val mActivity: FragmentActivity){

    private fun getMoviesApi() = mGlobalDependencyManager.getMovieApiInstance()

    fun getViewMvcFactory(): ViewMvcFactory = ViewMvcFactory(mActivity.layoutInflater)

    fun getMoviesListController(): MoviesListController = MoviesListController(getFetchMoviesUseCase())

    private fun getFetchMoviesUseCase() = FetchMoviesUseCase(getMoviesApi())



}