package com.example.moviesmvc.screens.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviesmvc.common.fragment.BaseFragment

class MovieDetailsFragment : BaseFragment(){

    lateinit var mViewMvc : MovieDetailsView
    lateinit var mController : MovieDetailsController


    companion object {
        fun getInstance(movieId : String) : Fragment {
            var args = Bundle()
            args.putString("movie_id", movieId)
            var movieDetailsFragment = MovieDetailsFragment()
            movieDetailsFragment.arguments = args
            return movieDetailsFragment
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewMvc = getControllerDependencyManager().getViewMvcFactory().getMovieDetailsViewMvc(container)
        mController = getControllerDependencyManager().getMovieDetailsController()
        mController.bindView(mViewMvc)
        return mViewMvc.getRootView()
    }

    override fun onStart() {
        super.onStart()
        var movieId = arguments?.get("movie_id") as String
        mController.onStart(movieId)
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }
}