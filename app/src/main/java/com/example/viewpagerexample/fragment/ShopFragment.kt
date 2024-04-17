package com.example.viewpagerexample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagerexample.R
import com.example.viewpagerexample.adapter.ShopAdapter
import com.example.viewpagerexample.data.Banner
import com.example.viewpagerexample.data.RecyclerItem
import com.example.viewpagerexample.data.ShopItem
import com.example.viewpagerexample.data.ShopItemType
import com.example.viewpagerexample.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    private lateinit var shopList: ArrayList<ShopItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        shopList = ArrayList()
        prepareData()

        val adapter = ShopAdapter(shopList)
        binding.mainRecyclerView.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun prepareData() {

        // best seller
        val bestSellerList = ArrayList<RecyclerItem>()
        bestSellerList.add(RecyclerItem(R.drawable.bags , "Up to 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.mobiles, "Up to 10% off"))
        bestSellerList.add(RecyclerItem(R.drawable.watches, "Up to 40% off"))
        bestSellerList.add(RecyclerItem(R.drawable.bags, "Up to 20% off"))
        bestSellerList.add(RecyclerItem(R.drawable.mobiles, "Up to 10% off"))
        bestSellerList.add(RecyclerItem(R.drawable.watches, "Up to 40% off"))

        //clothing
        val clothingList = ArrayList<RecyclerItem>()
        clothingList.add(RecyclerItem(R.drawable.levis_clothing, "Up to 25% off"))
        clothingList.add(RecyclerItem(R.drawable.women_clothing, "Up to 30% off"))
        clothingList.add(RecyclerItem(R.drawable.nikeshoes, "Up to 35% off"))
        clothingList.add(RecyclerItem(R.drawable.levis_clothing, "Up to 25% off"))
        clothingList.add(RecyclerItem(R.drawable.women_clothing, "Up to 30% off"))
        clothingList.add(RecyclerItem(R.drawable.nikeshoes, "Up to 35% off"))

        shopList.add(ShopItem(ShopItemType.BEST_SELLER, bestSellerList))
        shopList.add(ShopItem(ShopItemType.BANNER, Banner(R.drawable.tv_offer)))
        shopList.add(ShopItem(ShopItemType.CLOTHING, clothingList))
        shopList.add(ShopItem(ShopItemType.BANNER, Banner(R.drawable.nikon_canon_offer)))
        shopList.add(ShopItem(ShopItemType.BEST_SELLER, bestSellerList.asReversed()))
        shopList.add(ShopItem(ShopItemType.BANNER, Banner(R.drawable.offer_shoping)))
    }

}