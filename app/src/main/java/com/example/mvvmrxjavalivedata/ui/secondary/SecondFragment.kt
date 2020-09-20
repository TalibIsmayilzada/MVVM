package com.example.mvvmrxjavalivedata.ui.secondary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mvvmrxjavalivedata.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    private val args by navArgs<SecondFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        s.text = args.data.title
        d.text = args.data.body
    }
}