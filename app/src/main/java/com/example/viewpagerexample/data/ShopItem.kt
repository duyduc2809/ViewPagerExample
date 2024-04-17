package com.example.viewpagerexample.data

data class ShopItem(val shopItemViewType: Int) {

    var recyclerItemList: List<RecyclerItem>? = null
    var banner: Banner? = null

    constructor(viewType: Int, recyclerItemList: List<RecyclerItem>) : this(viewType) {
        this.recyclerItemList = recyclerItemList
    }

    constructor(viewType: Int, banner: Banner) : this(viewType) {
        this.banner = banner
    }
}

data class RecyclerItem(val image: Int, val offer: String)
data class Banner(val image: Int)