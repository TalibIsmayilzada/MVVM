package com.example.mvvmrxjavalivedata.data.api

import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("posts")
    fun getList(): Single<FakeResponse>
}