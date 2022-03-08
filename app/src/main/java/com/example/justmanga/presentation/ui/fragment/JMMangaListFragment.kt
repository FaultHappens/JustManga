package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.databinding.JmFragmentMangaListBinding
import com.example.justmanga.presentation.adapter.JMMangaListRVAdapter
import com.example.justmanga.presentation.vm.JMMangaListVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class JMMangaListFragment : Fragment() {


    private val vm: JMMangaListVM by viewModel()

    private lateinit var binding: JmFragmentMangaListBinding

    private val args: JMMangaInfoFragmentArgs by navArgs()

    private lateinit var mangaRVAdapter: JMMangaListRVAdapter
    private lateinit var mangaList: List<JMChapterModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mangaRVAdapter = JMMangaListRVAdapter{
            val action = JMMangaListFragmentDirections.actionJMMangaListFragmentToJMMangaDetailsFragment(it)
            findNavController().navigate(action)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mangaRV.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.mangaRV.adapter = mangaRVAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = JmFragmentMangaListBinding.inflate(layoutInflater)
        return binding.root
    }
}