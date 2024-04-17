package com.example.viewpagerexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerexample.data.RecyclerItem
import com.example.viewpagerexample.data.ShopItemType
import com.example.viewpagerexample.databinding.BestSellerLayoutBinding
import com.example.viewpagerexample.databinding.ClothingLayoutBinding

class ShopChildAdapter(
    private val viewType: Int,
    private val recyclerItemList: List<RecyclerItem>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BestSellerViewHolder(private val binding: BestSellerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindBestSellerView(recyclerItem: RecyclerItem) {
            binding.bestSellerImage.setImageResource(recyclerItem.image)
            binding.bestSellerText.text = recyclerItem.offer
        }
    }

    inner class ClothingViewHolder(private val binding: ClothingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindClothingView(recyclerItem: RecyclerItem) {
            binding.clothingImage.setImageResource(recyclerItem.image)
            binding.clothingOfferTv.text = recyclerItem.offer
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ShopItemType.BEST_SELLER -> {
                val binding = BestSellerLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BestSellerViewHolder(binding)
            }

            else -> {
                val binding = ClothingLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ClothingViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return recyclerItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is BestSellerViewHolder -> {
                holder.bindBestSellerView(recyclerItemList[position])
            }

            is ClothingViewHolder -> {
                holder.bindClothingView(recyclerItemList[position])
            }
        }
    }
}