package com.example.viewpagerexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerexample.R
import com.example.viewpagerexample.data.Banner
import com.example.viewpagerexample.data.RecyclerItem
import com.example.viewpagerexample.data.ShopItem
import com.example.viewpagerexample.data.ShopItemType
import com.example.viewpagerexample.databinding.BannerItemBinding
import com.example.viewpagerexample.databinding.EachItemBinding

class ShopAdapter(private val shopItemList: List<ShopItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BannerItemViewHolder(private val binding: BannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindBannerView(banner: Banner) {
            binding.bannerIv.setImageResource(banner.image)
        }
    }

    inner class RecyclerItemViewHolder(private val binding: EachItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager =
                LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }

        fun bindClothingRecyclerView(recyclerItemList: List<RecyclerItem>) {
            val adapter = ShopChildAdapter(ShopItemType.CLOTHING, recyclerItemList)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindBestSellerRecyclerView(recyclerItemList: List<RecyclerItem>) {

            val adapter = ShopChildAdapter(ShopItemType.BEST_SELLER, recyclerItemList)
            binding.childRecyclerView.adapter = adapter
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (shopItemList[position].shopItemViewType) {
            ShopItemType.BANNER ->
                R.layout.banner_item

            else ->
                R.layout.each_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.banner_item -> {
                val binding =
                    BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerItemViewHolder(binding)
            }

            else -> {
                val binding =
                    EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return shopItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BannerItemViewHolder -> {
                shopItemList[position].banner?.let { holder.bindBannerView(it) }
            }

            else ->
                when (shopItemList[position].shopItemViewType) {
                    ShopItemType.BEST_SELLER -> {
                        shopItemList[position].recyclerItemList?.let {
                            (holder as RecyclerItemViewHolder).bindBestSellerRecyclerView(
                                it
                            )
                        }
                    }

                    else -> {
                        shopItemList[position].recyclerItemList?.let {
                            (holder as RecyclerItemViewHolder).bindClothingRecyclerView(it)
                        }
                    }
                }
        }
    }
}