package com.example.moviesmvc.screens.moviedetails.characterslistitem

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesmvc.common.views.ObservableViewMvc
import com.example.moviesmvc.common.views.ViewMvc
import com.example.moviesmvc.model.MovieDetailsResponse

interface CharactersListItemView : ViewMvc {

    fun bindCharecterName(name: String)
}