package com.example.moviesmvc.common

abstract class BaseObservable<ListenerType> {
    private var listenersList = arrayListOf<ListenerType>()

    fun registerListener(listener: ListenerType) {
        listenersList.add(listener)
    }

    fun unregisterListener(listener: ListenerType) {
        listenersList.remove(listener)
    }


    protected fun getListeners() = listenersList as List<ListenerType>

}