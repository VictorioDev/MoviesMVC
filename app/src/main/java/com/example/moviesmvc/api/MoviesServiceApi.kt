package com.example.moviesmvc.api

import com.example.moviesmvc.BASE_URL
import com.example.moviesmvc.model.MovieDetailsResponse
import com.example.moviesmvc.model.MovieResponse
import com.example.moviesmvc.model.MoviesListResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesServiceApi {

    @GET("movie?api_key=d9a39e5d5e7d35b5932746b2ed50e761")
    fun getAllMovies() : Observable<MoviesListResponse>


    @GET("movie/{movieId}?api_key=d9a39e5d5e7d35b5932746b2ed50e761&language=en-US")
    fun getMovieDetails(@Path("movieId") movieId : String): Observable<MovieDetailsResponse>

}