package com.example.news_app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.TitleRecyclerviewBinding

class Adapter(private val items:MutableList<NewsItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding=TitleRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TitleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TitleViewHolder).itemView.setOnClickListener {
            Log.v("test","click")
            itemClick?.onClick(it,position)
        }
        val items=items[position]
        (holder as TitleViewHolder).bind(items)
    }

    inner class TitleViewHolder(private val binding : TitleRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item:NewsItem){
            binding.title.text=item.title
        }
    }
}