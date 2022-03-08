package com.example.justmanga.presentation.ui.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justmanga.R
import com.example.justmanga.data.room.entity.RecentManga
import com.example.justmanga.databinding.JmFragmentDashboardHomePageBinding
import com.example.justmanga.presentation.adapter.JMMainScreenButtonsRVAdapter
import com.example.justmanga.presentation.adapter.JMMainScreenHorizontalRVAdapter
import com.example.justmanga.presentation.vm.JMDashboardHomePageVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class JMDashboardHomePageFragment : Fragment() {

    private val vm: JMDashboardHomePageVM by viewModel()

    private lateinit var binding: JmFragmentDashboardHomePageBinding

    private lateinit var btnsRVAdapter: JMMainScreenButtonsRVAdapter
    private lateinit var popularMangasRVAdapter: JMMainScreenHorizontalRVAdapter
    private lateinit var recentMangasRVAdapter: JMMainScreenHorizontalRVAdapter
    private lateinit var newMangasRVAdapter: JMMainScreenHorizontalRVAdapter

    private var btnsList: MutableList<Pair<Bitmap, String>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFavouriteGenres()
        getPopularMangas()
        getNewMangas()
        initObservers()
        initAdapters()
        btnsRVAdapter.submitList(btnsList)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = JmFragmentDashboardHomePageBinding.inflate(layoutInflater)
        setWelcomingText()
        getRecentMangas()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            popularMangasRV.layoutManager = LinearLayoutManager(
                activity?.applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            popularMangasRV.adapter = popularMangasRVAdapter

            newMangasRV.layoutManager = LinearLayoutManager(
                activity?.applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            newMangasRV.adapter = newMangasRVAdapter

            val recentMangaLayoutManager = LinearLayoutManager(
                activity?.applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            recentMangaLayoutManager.stackFromEnd = true
            recentMangaLayoutManager.reverseLayout = true
            recentMangasRV.layoutManager = recentMangaLayoutManager
            recentMangasRV.adapter = recentMangasRVAdapter

            btnsLV.layoutManager = GridLayoutManager(activity?.applicationContext, 2)
            btnsLV.adapter = btnsRVAdapter

            profileBttn.setOnClickListener {
                it.findNavController().navigate(R.id.JMDashboardProfilePageFragment)
            }
            morePopularMangasBttn.setOnClickListener {
                it.findNavController().navigate(R.id.JMMangaListFragment)
            }

            moreNewMangasBttn.setOnClickListener {
                it.findNavController().navigate(R.id.JMMangaListFragment)
            }

            moreRecentMangasBttn.setOnClickListener {
                it.findNavController().navigate(R.id.JMMangaListFragment)
            }

        }

    }

    private fun initAdapters() {
        btnsRVAdapter = JMMainScreenButtonsRVAdapter { item ->
            findNavController().navigate(R.id.JMMangaListFragment)
        }
        popularMangasRVAdapter = JMMainScreenHorizontalRVAdapter { item ->
            addRecentManga(item.manga.id)
            val action =
                JMDashboardHomePageFragmentDirections.actionJMDashboardHomePageFragmentToJMMangaDetailsFragment(
                    item
                )
            findNavController().navigate(action)
        }
        recentMangasRVAdapter = JMMainScreenHorizontalRVAdapter { item ->
            addRecentManga(item.manga.id)
            val action =
                JMDashboardHomePageFragmentDirections.actionJMDashboardHomePageFragmentToJMMangaDetailsFragment(
                    item
                )
            findNavController().navigate(action)
        }
        newMangasRVAdapter = JMMainScreenHorizontalRVAdapter { item ->
            addRecentManga(item.manga.id)
            val action =
                JMDashboardHomePageFragmentDirections.actionJMDashboardHomePageFragmentToJMMangaDetailsFragment(
                    item
                )
            findNavController().navigate(action)
        }
    }

    private fun initObservers() {
        vm.popularMangaListLiveData.observe(this) {
            popularMangasRVAdapter.updateList(it)
        }
        vm.recentMangaListLiveData.observe(this) {
            recentMangasRVAdapter.updateList(it)
        }
        vm.newMangaListLiveData.observe(this) {
            newMangasRVAdapter.updateList(it)
        }

    }

    private fun addRecentManga(manga_id: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    vm.dao.addRecentManga(RecentManga(manga_id))
                } catch (e: Exception) {
                }
            }
        }

    }


    private fun getFavouriteGenres() {
        val drawable = ContextCompat.getDrawable(
            layoutInflater.context,
            R.drawable.jm_main_screen_btns_temp_holder
        )
        val bitmap = drawable?.let {
            Bitmap.createBitmap(
                it.intrinsicWidth,
                it.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
        }
        if (bitmap != null) {
            btnsList.add(Pair(bitmap, "Liked Manga"))
            btnsList.add(Pair(bitmap, "Romance"))
            btnsList.add(Pair(bitmap, "Isekai"))
            btnsList.add(Pair(bitmap, "Action"))
            btnsList.add(Pair(bitmap, "Sci-Fi"))
            btnsList.add(Pair(bitmap, "Slice Of Life"))
        }
    }

    private fun getPopularMangas() {
        vm.updatePopularMangaList()
    }

    private fun getRecentMangas() {
        vm.updateRecentMangaList()
    }

    private fun getNewMangas() {
        vm.updateNewMangaList()
    }


    private fun setWelcomingText() {
        val timeOfDay: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if (timeOfDay in 4..11) {
            binding.greetingsTV.text = getString(R.string.morning_greeting1)
        } else if (timeOfDay in 12..15) {
            binding.greetingsTV.text = getString(R.string.afternoon_greeting)
        } else if (timeOfDay in 16..20) {
            binding.greetingsTV.text = getString(R.string.evening_greeting1)
        } else if (timeOfDay in 21..23 || timeOfDay in 0..3) {
            binding.greetingsTV.text = getString(R.string.night_greeting1)
        }
    }
}