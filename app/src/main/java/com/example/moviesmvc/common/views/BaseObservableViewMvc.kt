package com.example.moviesmvc.common.views

abstract class BaseObservableViewMvc<ListenerType> : BaseViewMvc(), ObservableViewMvc<ListenerType>{

    private var listenersList = arrayListOf<ListenerType>()

    override fun registerListener(listener: ListenerType) {
        listenersList.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        listenersList.remove(listener)
    }


    protected fun getListeners() = listenersList as List<ListenerType>



}