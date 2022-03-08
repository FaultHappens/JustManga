package com.example.justmanga.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justmanga.R
import com.example.justmanga.data.dto.tag.response.JMTagModel
import com.example.justmanga.databinding.JmSearchTagCardBinding

class SearchScreenTagsArrayAdapter(private val listener: (JMTagModel) -> Unit,
                                   context: Context,
                                   private val resource: Int
): ArrayAdapter<JMTagModel>(context, resource) {

    private var tagList: List<JMTagModel> = listOf()

    fun updateList(newTagsList: List<JMTagModel>){
        tagList = newTagsList
        notifyDataSetChanged()
    }

    override fun getItem(position: Int) = tagList[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(resource, parent, false)
        view.findViewById<TextView>(R.id.tagText).text = tagList[position].attributes.name.en
        return view
    }

}