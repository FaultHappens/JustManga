package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.justmanga.R
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.databinding.JmFragmentMangaInfoBinding


class JMMangaInfoFragment : Fragment() {

    private lateinit var binding: JmFragmentMangaInfoBinding
    private lateinit var manga: JMMangaModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = JmFragmentMangaInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}