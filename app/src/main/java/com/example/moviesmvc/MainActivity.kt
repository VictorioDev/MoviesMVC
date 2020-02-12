package com.example.moviesmvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesmvc.movieslist.MoviesListFragment

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
