package com.example.moviesmvc.api

import com.example.moviesmvc.model.MoviesListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServiceApi {

    companion object {

        val BASE_URL = "https://api.themoviedb.org/3/discover"
    }


    @GET("/movie?api_key=d9a39e5d5e7d35b5932746b2ed50e761")

    fun getAllMovies() : Observable<MoviesListResponse>

}