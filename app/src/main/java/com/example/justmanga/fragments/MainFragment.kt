package com.example.justmanga.fragments

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.justmanga.R
import com.example.justmanga.adapters.MainScreenButtonsRVAdapter
import com.example.justmanga.databinding.FragmentMainBinding
import java.util.*
import androidx.core.content.ContextCompat

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.LinearLayoutManager


class MainFragment : Fragment() {

    private lateinit var btnsAdapter: MainScreenButtonsRVAdapter
    private lateinit var binding: FragmentMainBinding
    private var btnsList: MutableList<Pair<Bitmap, String>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFavouriteGenres()
        btnsAdapter = MainScreenButtonsRVAdapter { item ->
            Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
        }
        btnsAdapter.submitList(btnsList)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        setWelcomingText()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnsLV.layoutManager = LinearLayoutManager(activity?.applicationContext)
        binding.btnsLV.adapter = btnsAdapter
    }

    private fun getFavouriteGenres() {
        val drawable = ContextCompat.getDrawable(layoutInflater.context, R.drawable.like_icon)
        val bitmap = drawable?.let {
            Bitmap.createBitmap(
                it.intrinsicWidth,
                it.intrinsicHeight, Bitmap.Config.ARGB_8888
            )
        }
        if (bitmap != null){
            btnsList.add(Pair(bitmap, "Button1"))
            btnsList.add(Pair(bitmap, "Button1"))
            btnsList.add(Pair(bitmap, "Button1"))
            btnsList.add(Pair(bitmap, "Button1"))
            btnsList.add(Pair(bitmap, "Button1"))
            btnsList.add(Pair(bitmap, "Button1"))
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