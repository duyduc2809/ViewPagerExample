package com.example.viewpagerexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerexample.data.NewsItem
import com.example.viewpagerexample.databinding.NewsItemWithPosterBinding
import com.example.viewpagerexample.databinding.NewsItemWithoutPosterBinding

const val ITEM_WITH_POSTER = 0
const val ITEM_WITHOUT_POSTER = 1

class NewsAdapter(private val newList: List<NewsItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class NewsItemWithPosterViewHolder(private val binding: NewsItemWithPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindPosterView(dataItem: NewsItem) {
            dataItem.poster?.let { binding.newsPoster.setImageResource(it) }
            binding.movieTitle.text = dataItem.title
            binding.movieDesc.text = dataItem.desc
        }
    }

    inner class NewsItemWithoutPosterViewHolder(private val binding: NewsItemWithoutPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindWithoutPosterView(dataItem: NewsItem) {
            dataItem.logo?.let { binding.logoIv.setImageResource(it) }
            binding.movieTitleTv.text = dataItem.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (newList[position].poster != null) {
            ITEM_WITH_POSTER
        } else {
            ITEM_WITHOUT_POSTER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_WITH_POSTER) {
            val binding = NewsItemWithPosterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return NewsItemWithPosterViewHolder(binding)
        } else {
            val binding = NewsItemWithoutPosterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return NewsItemWithoutPosterViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ITEM_WITH_POSTER) {
            (holder as NewsItemWithPosterViewHolder).bindPosterView(newList[position])
        } else {
            (holder as NewsItemWithoutPosterViewHolder).bindWithoutPosterView(newList[position])
        }
    }
}