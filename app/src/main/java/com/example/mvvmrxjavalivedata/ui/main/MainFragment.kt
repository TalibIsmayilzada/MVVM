package com.example.mvvmrxjavalivedata.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.mvvmrxjavalivedata.R
import com.example.mvvmrxjavalivedata.data.api.API
import com.example.mvvmrxjavalivedata.data.api.RetrofitClient
import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import com.example.mvvmrxjavalivedata.data.models.FakeResponseItem
import com.example.mvvmrxjavalivedata.data.repository.NetworkState
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(),ExampleRecylcerAdapter.OnClicked {

    private lateinit var viewModel: ViewModel
    private lateinit var repository: Repository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apiService : API = RetrofitClient.getClient()
        repository = Repository(apiService)


        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return ViewModel(repository, 1) as T
            }
        })[ViewModel::class.java]


        viewModel.response.observe(viewLifecycleOwner, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(viewLifecycleOwner, Observer {
            loading.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            //txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE
        })
    }


    fun bindUI(response: FakeResponse){
        list.apply {
            hasFixedSize()
            adapter = ExampleRecylcerAdapter(response,this@MainFragment)
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onClicked(repsonse: FakeResponseItem) {
        val action = MainFragmentDirections.actionMainFragmentToSecondFragment(repsonse)
        findNavController().navigate(action)
    }
}