package com.example.moviesmvc.screens.moviedetails.characterslistitem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.moviesmvc.common.views.BaseViewMvc

class CharactersListItemViewImpl(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : CharactersListItemView, BaseViewMvc() {


    init {
        setRootView(layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false))
    }

    override fun bindCharecterName(name: String) {
        ( getRootView() as TextView).text = name
    }
}