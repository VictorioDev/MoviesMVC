package com.example.moviesmvc.common.main

import android.view.LayoutInflater
import com.example.moviesmvc.R
import com.example.moviesmvc.common.fragment.FragmentFrameHelper
import com.example.moviesmvc.common.views.BaseObservableViewMvc
import com.example.moviesmvc.common.views.BaseViewMvc
import kotlinx.android.synthetic.main.activity_main.view.*

class MainViewMvcImpl(layoutInflater: LayoutInflater) : BaseViewMvc(), MainViewMvc {

    override fun getFragmentWrapper() = getRootView().fragment_container

    override fun getFragmentHelper(): FragmentFrameHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        setRootView(layoutInflater.inflate(R.layout.activity_main, null, false))
    }



}