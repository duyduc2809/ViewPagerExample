package com.example.viewpagerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerexample.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val tabsArray = arrayOf("Feeds", "Shop")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val myAdapter = ViewPagerAdapter(
            supportFragmentManager,
            lifecycle
        )

        viewPager.isUserInputEnabled = false
        viewPager.adapter = myAdapter

        TabLayoutMediator(tabLayout, viewPager) {
            tab, position -> tab.text = tabsArray[position]
        }.attach()

    }
}