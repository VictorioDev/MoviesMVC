package com.example.moviesmvc.common.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesmvc.R
import com.example.moviesmvc.screens.movieslist.MoviesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState == null){
            var fragment = MoviesListFragment()
            var transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container, fragment).commit()
        }

    }
}
