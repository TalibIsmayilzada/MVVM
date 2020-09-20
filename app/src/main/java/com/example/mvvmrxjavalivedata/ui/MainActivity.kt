package com.example.mvvmrxjavalivedata.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.mvvmrxjavalivedata.R
import com.example.mvvmrxjavalivedata.data.api.API
import com.example.mvvmrxjavalivedata.data.api.RetrofitClient.getClient
import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import com.example.mvvmrxjavalivedata.data.repository.NetworkState
import com.example.mvvmrxjavalivedata.ui.main.ExampleRecylcerAdapter
import com.example.mvvmrxjavalivedata.ui.main.Repository
import com.example.mvvmrxjavalivedata.ui.main.ViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}