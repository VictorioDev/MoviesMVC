package com.example.moviesmvc.common.main

import android.view.View
import com.example.moviesmvc.common.fragment.FragmentFrameHelper
import com.example.moviesmvc.common.views.ViewMvc
interface MainViewMvc : ViewMvc {

    fun getFragmentWrapper() : View

    fun getFragmentHelper(): FragmentFrameHelper
}