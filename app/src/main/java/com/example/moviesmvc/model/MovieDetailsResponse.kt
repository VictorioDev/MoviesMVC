package com.example.moviesmvc.model

data class MovieDetailsResponse(
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val overview: String,
    val poster_path : String
)