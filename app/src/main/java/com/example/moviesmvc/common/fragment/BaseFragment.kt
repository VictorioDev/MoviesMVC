package com.example.moviesmvc.common.fragment

import androidx.fragment.app.Fragment
import com.example.moviesmvc.common.MoviesApplication
import com.example.moviesmvc.common.dependencyinjection.ControllerDependencyManager

abstract class BaseFragment : Fragment(){

    private var mControllerDependencyManager: ControllerDependencyManager? = null

    fun getControllerDependencyManager() : ControllerDependencyManager {
        return mControllerDependencyManager ?:
            ControllerDependencyManager((activity?.application as MoviesApplication).getGlobalDependencyManager(), requireActivity())
                .also { mControllerDependencyManager = it }
    }

}