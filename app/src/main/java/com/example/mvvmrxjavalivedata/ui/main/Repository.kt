package com.example.mvvmrxjavalivedata.ui.main

import androidx.lifecycle.LiveData
import com.example.mvvmrxjavalivedata.data.api.API
import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import com.example.mvvmrxjavalivedata.data.repository.DataSource
import com.example.mvvmrxjavalivedata.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class Repository(private val apiService : API) {

    private lateinit var movieDetailsNetworkDataSource: DataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<FakeResponse> {

        movieDetailsNetworkDataSource = DataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.response

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}