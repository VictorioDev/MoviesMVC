package com.example.moviesmvc.model

data class MoviesListResponse(
    val page: Int,
    val movieResponses: List<MovieResponse>,
    val total_pages: Int,
    val total_results: Int
)