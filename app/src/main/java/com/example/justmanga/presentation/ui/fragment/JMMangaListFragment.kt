package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.justmanga.R
import com.example.justmanga.presentation.vm.JMMangaInfoVM
import com.example.justmanga.presentation.vm.JMMangaListVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class JMMangaListFragment : Fragment() {


    private val vm: JMMangaListVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.jm_fragment_manga_list, container, false)
    }
}