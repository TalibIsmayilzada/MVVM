package com.example.mvvmrxjavalivedata.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmrxjavalivedata.data.api.API
import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DataSource(
    private val apiService: API,
    private val compositeDisposable: CompositeDisposable
) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _response = MutableLiveData<FakeResponse>()
    val response: LiveData<FakeResponse>
        get() = _response

    fun fetchMovieDetails(movieId: Int) {

        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getList()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _response.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                        }
                    )
            )

        } catch (e: Exception) {
        }


    }
}