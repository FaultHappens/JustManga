package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.justmanga.R
import com.example.justmanga.data.dto.tag.response.JMTagModel
import com.example.justmanga.databinding.JmFragmentDashboardSearchPageBinding
import com.example.justmanga.presentation.adapter.JMSearchScreenTagsArrayAdapter
import com.example.justmanga.presentation.vm.JMDashboardSearchPageVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class JMDashboardSearchPageFragment : Fragment() {

    private val vm: JMDashboardSearchPageVM by viewModel()

    private lateinit var tagsArrayAdapterJM: JMSearchScreenTagsArrayAdapter

    private var tagsList: List<JMTagModel> = listOf()

    private lateinit var binding: JmFragmentDashboardSearchPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getTagList()

        vm.tagLiveData.observe(this, {
            tagsList = it
            tagsArrayAdapterJM.updateList(tagsList)
        })

        tagsArrayAdapterJM = activity?.let {
            JMSearchScreenTagsArrayAdapter({
                Toast.makeText(layoutInflater.context, "Click", Toast.LENGTH_SHORT).show()
            }, it, R.layout.jm_search_tag_card)
        }!!


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = JmFragmentDashboardSearchPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tagsGridView.adapter = tagsArrayAdapterJM
    }

    private fun getTagList(){
        vm.updateTagList()
    }
}