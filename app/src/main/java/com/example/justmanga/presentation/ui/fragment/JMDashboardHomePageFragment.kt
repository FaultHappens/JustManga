package com.example.justmanga.presentation.ui.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justmanga.R
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.databinding.JmFragmentDashboardHomePageBinding
import com.example.justmanga.presentation.adapter.MainScreenButtonsRVAdapter
import com.example.justmanga.presentation.adapter.MainScreenHorizontalRVAdapter
import com.example.justmanga.presentation.vm.JMDashboardHomePageVM
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class JMDashboardHomePageFragment : Fragment() {

    private val vm: JMDashboardHomePageVM by viewModel()

    private lateinit var binding: JmFragmentDashboardHomePageBinding

    private lateinit var btnsRVAdapter: MainScreenButtonsRVAdapter
    private lateinit var popularMangasRVAdapter: MainScreenHorizontalRVAdapter
    private lateinit var recentMangasRVAdapter: MainScreenHorizontalRVAdapter
    private lateinit var newMangasRVAdapter: MainScreenHorizontalRVAdapter

    private var btnsList: MutableList<Pair<Bitmap, String>> = mutableListOf()
    private var popularMangasList: List<JMMangaModel> = listOf()
    private var recentMangasList: MutableList<Pair<Bitmap, String>> = mutableListOf()
    private var newMangasList: MutableList<Pair<Bitmap, String>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFavouriteGenres()
        getPopularMangas()
        getRecentMangas()
        getNewMangas()
        vm.mangaListLiveData.observe(this, {
            popularMangasList = it
        })
        btnsRVAdapter = MainScreenButtonsRVAdapter { item ->
            Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
        }
        popularMangasRVAdapter = MainScreenHorizontalRVAdapter { item ->
            Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
        }
        recentMangasRVAdapter = MainScreenHorizontalRVAdapter { item ->
            Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
        }
        newMangasRVAdapter = MainScreenHorizontalRVAdapter { item ->
            Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
        }
        btnsRVAdapter.submitList(btnsList)
        popularMangasRVAdapter.submitList(popularMangasList)
//        recentMangasRVAdapter.submitList(recentMangasList)
//        newMangasRVAdapter.submitList(newMangasList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = JmFragmentDashboardHomePageBinding.inflate(layoutInflater)
        setWelcomingText()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.popularMangasRV.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
        binding.popularMangasRV.adapter = popularMangasRVAdapter
        
        binding.newMangasRV.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
        binding.newMangasRV.adapter = newMangasRVAdapter
        
        binding.recentMangasRV.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)
        binding.recentMangasRV.adapter = recentMangasRVAdapter

        binding.btnsLV.layoutManager = GridLayoutManager(activity?.applicationContext, 2)
        binding.btnsLV.adapter = btnsRVAdapter

        binding.profileBttn.setOnClickListener{
            it.findNavController().navigate(R.id.JMDashboardProfilePageFragment)
        }
    }

    private fun getFavouriteGenres() {
        val drawable = ContextCompat.getDrawable(layoutInflater.context, R.drawable.jm_like_icon)
        val bitmap = drawable?.let {
            Bitmap.createBitmap(
                it.intrinsicWidth,
                it.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
        }
        if (bitmap != null){
            btnsList.add(Pair(bitmap, "Liked Manga"))
            btnsList.add(Pair(bitmap, "Romance"))
            btnsList.add(Pair(bitmap, "Isekai"))
            btnsList.add(Pair(bitmap, "Action"))
            btnsList.add(Pair(bitmap, "Sci-Fi"))
            btnsList.add(Pair(bitmap, "Slice Of Life"))
        }
    }

    private fun getPopularMangas() {
        vm.updateMangaList()
    }

    private fun getRecentMangas() {
        val drawable = ContextCompat.getDrawable(layoutInflater.context, R.drawable.jm_like_icon)
        val bitmap = drawable?.let {
            Bitmap.createBitmap(
                it.intrinsicWidth,
                it.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
        }
        if (bitmap != null){
            recentMangasList.add(Pair(bitmap, "Recent Manga Name"))
            recentMangasList.add(Pair(bitmap, "Recent Manga Name"))
            recentMangasList.add(Pair(bitmap, "Recent Manga Name"))
            recentMangasList.add(Pair(bitmap, "Recent Manga Name"))
            recentMangasList.add(Pair(bitmap, "Recent Manga Name"))
            recentMangasList.add(Pair(bitmap, "Recent Manga Name"))
        }
    }

    private fun getNewMangas() {
        val drawable = ContextCompat.getDrawable(layoutInflater.context, R.drawable.jm_like_icon)
        val bitmap = drawable?.let {
            Bitmap.createBitmap(
                it.intrinsicWidth,
                it.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
        }
        if (bitmap != null){
            newMangasList.add(Pair(bitmap, "Manga Name"))
            newMangasList.add(Pair(bitmap, "Manga Name"))
            newMangasList.add(Pair(bitmap, "Manga Name"))
            newMangasList.add(Pair(bitmap, "Manga Name"))
            newMangasList.add(Pair(bitmap, "Manga Name"))
            newMangasList.add(Pair(bitmap, "Manga Name"))


        }
    }


    private fun setWelcomingText() {
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
        if (timeOfDay >= 4 && timeOfDay < 12) {
            binding.greetingsTV.text = getString(R.string.morning_greeting1)
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            binding.greetingsTV.text = getString(R.string.afternoon_greeting)
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            binding.greetingsTV.text = getString(R.string.evening_greeting1)
        } else if (timeOfDay >= 21 && timeOfDay < 24 || timeOfDay >= 0 && timeOfDay < 4) {
            binding.greetingsTV.text = getString(R.string.night_greeting1)
        }
    }
}