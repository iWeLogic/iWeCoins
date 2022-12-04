package com.iwelogic.news_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iwelogic.news_domain.models.News
import com.iwelogic.news_presentation.databinding.ItemNewsBinding

class NewsAdapter(private val onClick: (News) -> Unit) : ListAdapter<News, RecyclerView.ViewHolder>(CoinComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AppViewHolder) {
            holder.bind(position)
        }
    }

    private inner class AppViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = getItem(position)
            binding.title.text = item.title
            binding.root.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}

object CoinComparator : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean = oldItem == newItem
}
