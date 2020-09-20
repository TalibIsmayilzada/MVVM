package com.example.mvvmrxjavalivedata.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import com.example.mvvmrxjavalivedata.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class ViewModel(private val repository : Repository, movieId: Int): ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val  response : LiveData<FakeResponse> by lazy {
        repository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        repository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}