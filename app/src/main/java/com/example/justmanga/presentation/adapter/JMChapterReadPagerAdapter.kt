package com.example.justmanga.presentation.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.justmanga.R
import com.example.justmanga.presentation.ui.fragment.JMChapterPageFragment

class JMChapterReadPagerAdapter(
    fa: FragmentActivity,
    private val linkList: List<String>,
    private val chapterHash: String,
    private val clickListener: () -> Unit
    ): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = linkList.count()
    override fun createFragment(position: Int): Fragment = JMChapterPageFragment(linkList[position], chapterHash, clickListener)
}