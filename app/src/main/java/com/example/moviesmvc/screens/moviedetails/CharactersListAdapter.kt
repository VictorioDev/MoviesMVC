package com.example.moviesmvc.screens.moviedetails

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvc.common.factory.ViewMvcFactory
import com.example.moviesmvc.screens.moviedetails.characterslistitem.CharactersListItemView


class CharactersListAdapter(private var viewMvcFactory: ViewMvcFactory) : RecyclerView.Adapter<CharactersListAdapter.CharactersViewHolder>() {

    var characters = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        var viewMvc = viewMvcFactory.getCharactersListItemView(parent)
        return CharactersViewHolder(viewMvc)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
       holder.view.bindCharecterName(characters[position])
    }

    fun bindCharacters(namesList : List<String>){
        characters.addAll(namesList)
        notifyDataSetChanged()
    }

    inner class CharactersViewHolder(var view : CharactersListItemView) : RecyclerView.ViewHolder(view.getRootView())
}