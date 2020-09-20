package com.example.mvvmrxjavalivedata.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrxjavalivedata.R
import com.example.mvvmrxjavalivedata.data.models.FakeResponse
import com.example.mvvmrxjavalivedata.data.models.FakeResponseItem
import kotlinx.android.synthetic.main.recylcer_item.view.*

class ExampleRecylcerAdapter(private val list: FakeResponse, private val listener: OnClicked): RecyclerView.Adapter<ExampleRecylcerAdapter.ExampleViewHolder>(){
    inner class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        return ExampleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recylcer_item,parent,false))
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.itemView.title.text = list[position].title
        holder.itemView.body.text = list[position].body

        holder.itemView.setOnClickListener {
            listener.onClicked(list[position])
        }
    }

    override fun getItemCount() = list.size

    interface OnClicked{
        fun onClicked(repsonse: FakeResponseItem)
    }

}