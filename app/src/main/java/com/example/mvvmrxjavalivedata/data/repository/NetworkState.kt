package com.example.mvvmrxjavalivedata.data.repository


enum class Status{
    LOADING,
    SUCCESS,
    ERROR
}

class NetworkState(val status: Status, val message: String) {

    companion object{
        val LOADED: NetworkState = NetworkState(Status.SUCCESS, "Success")
        val LOADING: NetworkState = NetworkState(Status.LOADING,"Loading")
        val ERROR: NetworkState = NetworkState(Status.ERROR,"Something went wrong")
    }
}