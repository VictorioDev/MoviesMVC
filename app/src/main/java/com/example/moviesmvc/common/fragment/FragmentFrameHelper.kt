package com.example.moviesmvc.common.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.moviesmvc.common.main.MainViewMvc

class FragmentFrameHelper(private var mainViewMvc: MainViewMvc, private var mFragmentManager: FragmentManager) {

    fun replaceFragment(mFragment : Fragment, fragmentName: String?){
        var fragmentTransaction = mFragmentManager.beginTransaction().addToBackStack(fragmentName)
        fragmentTransaction.replace(mainViewMvc.getFragmentWrapper().id, mFragment).commit()
    }
}