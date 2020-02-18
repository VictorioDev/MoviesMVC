package com.example.moviesmvc.common.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesmvc.screens.moviedetails.MoviesDetailsViewImpl
import com.example.moviesmvc.screens.moviedetails.characterslistitem.CharactersListItemView
import com.example.moviesmvc.screens.moviedetails.characterslistitem.CharactersListItemViewImpl
import com.example.moviesmvc.screens.movieslist.MovieListViewMvcImpl
import com.example.moviesmvc.screens.movieslist.movielistitem.MovieListItemViewMvc
import com.example.moviesmvc.screens.movieslist.movielistitem.MovieListItemViewMvcImpl

class ViewMvcFactory(
    private val layoutInflater: LayoutInflater) {

    fun getMoviesListViewMvc(parent: ViewGroup?) = MovieListViewMvcImpl(layoutInflater, parent, this)

    fun getMoviesListItemViewMvc(parent: ViewGroup?) : MovieListItemViewMvc = MovieListItemViewMvcImpl(
        layoutInflater, parent)

    fun getMovieDetailsViewMvc(parent: ViewGroup?) = MoviesDetailsViewImpl(layoutInflater, parent, this)
    fun getCharactersListItemView(parent: ViewGroup?): CharactersListItemView = CharactersListItemViewImpl(layoutInflater, parent)
}