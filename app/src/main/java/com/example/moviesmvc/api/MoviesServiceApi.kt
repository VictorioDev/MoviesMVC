package com.example.moviesmvc.api

import com.example.moviesmvc.model.MovieDetailsResponse
import com.example.moviesmvc.model.MoviesListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesServiceApi {

    @GET("discover/movie?api_key=d9a39e5d5e7d35b5932746b2ed50e761")
    fun getAllMovies() : Observable<MoviesListResponse>


    @GET("movie/{movieId}?api_key=d9a39e5d5e7d35b5932746b2ed50e761&language=en-US")
    fun getMovieDetails(@Path("movieId") movieId : String): Observable<MovieDetailsResponse>

}