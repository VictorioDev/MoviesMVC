package com.example.moviesmvc.api

import com.example.moviesmvc.BASE_URL
import com.example.moviesmvc.model.MoviesListResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServiceApi {

    companion object {

        private var instance : MoviesServiceApi? = null

        fun getInstance() : MoviesServiceApi{
            return instance ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(MoviesServiceApi::class.java).also { instance = it }
        }
    }


    @GET("/movie?api_key=d9a39e5d5e7d35b5932746b2ed50e761")

    fun getAllMovies() : Observable<MoviesListResponse>

}