package com.example.viewpagerexample.data

data class NewsItem (
    val title: String,
    val desc: String?,
    val poster: Int?,
    val logo: Int?
)

sealed class NewsItemTypes {
    data class  ResponseOne (
        val title: String,
        val desc: String,
        val poster: Int
    ) : NewsItemTypes()

    data class  ResponseTwo (
        val title: String,
        val logo: Int
    ) : NewsItemTypes()
}