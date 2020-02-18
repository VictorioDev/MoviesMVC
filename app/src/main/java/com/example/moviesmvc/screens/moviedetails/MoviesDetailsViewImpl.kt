package com.example.moviesmvc.screens.moviedetails

import android.animation.ObjectAnimator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.moviesmvc.IMAGE_PATH_BASE_URL
import com.example.moviesmvc.R
import com.example.moviesmvc.common.factory.ViewMvcFactory
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.model.MovieDestailsResponse2
import com.google.android.material.bottomsheet.BottomSheetBehavior

import kotlinx.android.synthetic.main.characters_list_2.view.*
import kotlinx.android.synthetic.main.movies_details_fragment.view.*

import com.google.android.material.card.MaterialCardView


class MoviesDetailsViewImpl(
     layoutInflater: LayoutInflater,
    parent : ViewGroup?,
     var viewMvcFactory: ViewMvcFactory
) : BaseObservableViewMvc<MovieDetailsView.Listener>(),
                            MovieDetailsView {

    var mAdapter = CharactersListAdapter(viewMvcFactory)


    override fun bindMovieDetails(movieDetailsResponse: MovieDestailsResponse2) {
        getRootView().progress_bar_details.visibility = View.INVISIBLE
        getRootView().movie_container.visibility = View.VISIBLE
        Glide.with(getContext()).load(IMAGE_PATH_BASE_URL + movieDetailsResponse.poster_path).into(getRootView().movie_cover)
        getRootView().movie_budget.text = "R$${movieDetailsResponse.budget}"
        getRootView().movie_overview.text = "${movieDetailsResponse.overview}"
        var characters = movieDetailsResponse.credits.cast.map {
            cast -> cast.character
        }
        mAdapter.bindCharacters(characters)
    }


    init {
        setRootView(layoutInflater.inflate(R.layout.movies_details_fragment, parent, false))
        getRootView().btn_cast.setOnClickListener {
            animateCharactersContainer()
        }




    }


    override fun animateCharactersContainer() {

        var viewStub = getRootView().characters_view_stub.inflate().also {
            getRootView().rv_characters.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }

        var  bottomSheetBehavior = BottomSheetBehavior.from(viewStub.pill_container);
        bottomSheetBehavior.setHideable(false);
        var startPoint = getRootView().height.toFloat()
        var endPoint = (startPoint / 2)
        var alphaAnimation = ObjectAnimator.ofFloat(viewStub, "alpha", 0f , 1f)
        Log.d("VAZP", "Height -> $startPoint")
        var translateYAnimation = ObjectAnimator.ofFloat(viewStub.pill_container, "translationY", startPoint, endPoint)
        bottomSheetBehavior.setPeekHeight(endPoint.toInt())
        alphaAnimation.apply {
            duration = 200
            interpolator = AccelerateInterpolator()
            doOnEnd {
                translateYAnimation.apply {
                    duration = 350
                    interpolator = AccelerateInterpolator()
                    doOnStart {
                        viewStub.pill_container.visibility = View.VISIBLE
                    }
                }.start()
            }
        }.start()
    }
}