package com.example.moviesmvc.model

data class MovieDestailsResponse2(
    val budget: Int,
    val credits: Credits,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val title: String
)