package com.example.viewpagerexample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagerexample.R
import com.example.viewpagerexample.adapter.NewsAdapter
import com.example.viewpagerexample.data.NewsItem
import com.example.viewpagerexample.databinding.ActivityMainBinding
import com.example.viewpagerexample.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsList: ArrayList<NewsItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsRecyclerView.setHasFixedSize(true)
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        newsList = ArrayList()
        prepareData()

        val adapter = NewsAdapter(newsList)
        binding.newsRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun prepareData() {

        newsList.add(
            NewsItem(
                "Captain America : The First Avenger",
                "During World War II, Steve Rogers decides to volunteer in an experiment that transforms his weak body. He must now battle a secret Nazi organisation headed by Johann Schmidt to defend his nation.",
                R.drawable.captain,
                null
            )
        )
        newsList.add(
            NewsItem(
                "The Incredible Hulk",
                null,
                null,
                R.drawable.hulk_logo
            )
        )

        newsList.add(
            NewsItem(
                "Avengers: Endgame",
                "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
                R.drawable.avengers_endgame,
                null
            )
        )

        newsList.add(
            NewsItem(
                "Doctor Strange",
                null,
                null,
                R.drawable.doc_strange_logo
            )
        )

        newsList.add(
            NewsItem(
                "Captain America : The First Avenger",
                "During World War II, Steve Rogers decides to volunteer in an experiment that transforms his weak body. He must now battle a secret Nazi organisation headed by Johann Schmidt to defend his nation.",
                R.drawable.captain,
                null
            )
        )

        newsList.add(
            NewsItem(
                "Avengers: Endgame",
                "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
                R.drawable.avengers_endgame,
                null
            )
        )

        newsList.add(
            NewsItem(
                "The Incredible Hulk",
                null,
                null,
                R.drawable.hulk_logo
            )
        )
    }

}