package com.example.moviesmvc.common

import android.app.Application
import com.example.moviesmvc.common.dependencyinjection.GlobalDependencyManager

class MoviesApplication : Application() {

    private lateinit var mGlobalDependencyManager: GlobalDependencyManager

    override fun onCreate() {
        super.onCreate()
        mGlobalDependencyManager = GlobalDependencyManager()
    }

    fun getGlobalDependencyManager() = mGlobalDependencyManager
}