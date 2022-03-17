package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justmanga.data.dto.tag.response.JMTagModel
import com.example.justmanga.databinding.JmFragmentDashboardSearchPageBinding
import com.example.justmanga.presentation.adapter.JMSearchScreenTagsRVAdapter
import com.example.justmanga.presentation.vm.JMDashboardSearchPageVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class JMDashboardSearchPageFragment : Fragment() {

    private val vm: JMDashboardSearchPageVM by viewModel()

    private lateinit var layoutManager: GridLayoutManager

    private lateinit var tagsRVAdapter: JMSearchScreenTagsRVAdapter

    private var tagsList: List<JMTagModel> = listOf()

    private lateinit var binding: JmFragmentDashboardSearchPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.tagLiveData.observe(this) {
            tagsList = it
            tagsRVAdapter.updateList(tagsList)
            layoutManager = GridLayoutManager(activity?.applicationContext, 40, GridLayoutManager.VERTICAL, false)
            layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    Log.d("SPANSIZE", "Span size of ${tagsList[position].attributes.name.en.length} for ${tagsList[position].attributes.name.en}")
                    return tagsList[position].attributes.name.en.length
                }
            }
            binding.tagsRV.layoutManager = layoutManager
        }

        tagsRVAdapter = JMSearchScreenTagsRVAdapter {
                Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getTagList()
        binding = JmFragmentDashboardSearchPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tagsRV.adapter = tagsRVAdapter
    }

    private fun getTagList(){
        vm.updateTagList()
    }
}