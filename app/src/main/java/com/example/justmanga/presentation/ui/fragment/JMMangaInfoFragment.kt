package com.example.justmanga.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.databinding.JmFragmentMangaInfoBinding
import com.example.justmanga.presentation.adapter.JMMangaInfoChaptersRVAdapter
import com.example.justmanga.presentation.ui.activity.JMChapterReadActivity
import com.example.justmanga.presentation.vm.JMMangaInfoVM
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class JMMangaInfoFragment : Fragment() {

    private val vm: JMMangaInfoVM by viewModel()

    private lateinit var binding: JmFragmentMangaInfoBinding
    private lateinit var manga: JMMangaModel
    private lateinit var coverID: String
    private val args: JMMangaInfoFragmentArgs by navArgs()


    private lateinit var chaptersRVAdapter: JMMangaInfoChaptersRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manga = args.mangaWithCoverModel.manga
        coverID = args.mangaWithCoverModel.coverID

        chaptersRVAdapter = JMMangaInfoChaptersRVAdapter { item ->
            val intent = Intent(context, JMChapterReadActivity::class.java)
            intent.putExtra("chapterId", item.id)
            intent.putExtra("chapterNumb", item.attributes.chapter)
            startActivity(intent)
        }

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
        loadMangaInfo()
        loadMangaChapters()

        binding.chaptersRV.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.chaptersRV.adapter = chaptersRVAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            vm.mangaChaptersListLiveData.observe(viewLifecycleOwner) {
                chaptersRVAdapter.submitData(lifecycle, it)
            }
        }
    }

    private fun loadMangaChapters() {
        vm.updateMangaChaptersList(args.mangaWithCoverModel.manga.id)
    }


    private fun loadMangaInfo() {
        val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
        circularProgressDrawable.strokeWidth = 20f
        circularProgressDrawable.centerRadius = 100f
        circularProgressDrawable.start()
        var altText = "NONE"

        if (manga.attributes.altTitles != null) {
            manga.attributes.altTitles!!.forEach {
                if (it.containsKey("ja")) {
                    altText = it["ja"].toString()
                    return@forEach
                }
            }
        }

        var description: String = ""
        if (manga.attributes.description!!.containsKey("en")) {
            description = manga.attributes.description!!["en"].toString()
        }

        var genresText = ""
        if (manga.attributes.tags != null) {
            for (i in manga.attributes.tags!!) {
                genresText += i.attributes?.name!!["en"] ?: "None"
                genresText += ", "
            }
        }
        with(binding) {
            mangaNameTV.text = manga.attributes.title["en"]
            descriptionTV.text = description
            altNamesTV.text = altText
//            for(i in manga.relationships){
//                when(i.type){
//                    "author" -> authorNameTV
//                    "artist" -> authorNameTV
//                }
//            }
            //TODO: Request to get author and artist names
            statusTV.text = manga.attributes.status

            genresTV.text = genresText
            Glide.with(binding.root)
                .load("https://uploads.mangadex.org/covers/${manga.id}/${coverID}.512.jpg")
                .placeholder(circularProgressDrawable)
                .centerCrop()
                .into(mangaImage)
        }

    }
}