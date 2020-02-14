package com.example.moviesmvc.common.dependencyinjection

import com.example.moviesmvc.BASE_URL
import com.example.moviesmvc.api.MoviesServiceApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GlobalDependencyManager {

    var moviesApiInstance: MoviesServiceApi? = null

    fun getMovieApiInstance() : MoviesServiceApi{
        return moviesApiInstance ?: Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(MoviesServiceApi::class.java).also { moviesApiInstance = it }
    }
}