package com.iwelogic.coins_presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iwelogic.coins_presentation.R
import com.iwelogic.coins_presentation.databinding.ItemCoinBinding
import com.iwelogic.coins_presentation.models.Coin

class CoinAdapter(private val onClick: (Coin) -> Unit) : ListAdapter<Coin, RecyclerView.ViewHolder>(CoinComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppViewHolder(ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AppViewHolder) {
            holder.bind(position)
        }
    }

    private inner class AppViewHolder(private val binding: ItemCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = getItem(position)
            binding.itemContainer.setBackgroundColor(ContextCompat.getColor(binding.image.context, if (position % 2 == 0) R.color.white else R.color.gray))
            binding.title.text = item.name
            val pricePlaceHolder = binding.title.context.getString(
                if ((item.priceChange24h ?: 0.0) > 0.0) R.string.global_arrow_up
                else R.string.global_arrow_down
            )
            val priceTextColor =
                if ((item.priceChange24h ?: 0.0) > 0.0) R.color.green
                else R.color.red
            binding.price.text = String.format(pricePlaceHolder, item.priceChangePercentage24h)
            binding.price.setTextColor(ContextCompat.getColor(binding.price.context, priceTextColor))
            Glide.with(binding.image).load(item.image).into(binding.image)
            binding.root.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}

object CoinComparator : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean = oldItem == newItem
}
