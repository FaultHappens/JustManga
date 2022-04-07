package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.R
import com.example.justmanga.data.dto.chapter.response.JMChapterModel
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.data.enum.ChapterSortType
import com.example.justmanga.databinding.JmFragmentMangaInfoBinding
import com.example.justmanga.presentation.adapter.JMMangaInfoChaptersRVAdapter
import com.example.justmanga.presentation.vm.JMMangaInfoVM
import org.koin.androidx.viewmodel.ext.android.viewModel


class JMMangaInfoFragment : Fragment() {

    private val vm: JMMangaInfoVM by viewModel()

    private var chapterSort: ChapterSortType = ChapterSortType.ASCENDING

    private lateinit var binding: JmFragmentMangaInfoBinding
    private lateinit var manga: JMMangaModel
    private lateinit var coverID: String
    private val args: JMMangaInfoFragmentArgs by navArgs()


    private lateinit var chaptersRVAdapter: JMMangaInfoChaptersRVAdapter

    private lateinit var mangaChaptersList: List<JMChapterModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manga = args.mangaWithCoverModel.manga
        coverID = args.mangaWithCoverModel.coverID

        chaptersRVAdapter = JMMangaInfoChaptersRVAdapter { item ->
            //TODO: navigation to chapter reading fragment with JMChapterModel argument
//            val action = JMDashboardHomePageFragmentDirections.actionJMDashboardHomePageFragmentToJMMangaDetailsFragment(item)
//            findNavController().navigate(action)
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
        binding.chaptersRV.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.chaptersRV.adapter = chaptersRVAdapter
        loadMangaInfo()
        loadMangaChapters()
        vm.mangaChaptersListLiveData.observe(viewLifecycleOwner) {
            chaptersRVAdapter.submitData(lifecycle, it)
        }
        binding.chapterSortBttn.setOnClickListener {
            when(chapterSort){
                ChapterSortType.ASCENDING -> {
                    chapterSort = ChapterSortType.DESCENDING
                    binding.chapterSortBttnIcon.setImageDrawable(activity?.applicationContext?.let { it1 ->
                        getDrawable(
                            it1, R.drawable.jm_desc_button_icon)
                    })
                }
                ChapterSortType.DESCENDING -> {
                    chapterSort = ChapterSortType.DESCENDING
                    binding.chapterSortBttnIcon.setImageDrawable(activity?.applicationContext?.let { it1 ->
                        getDrawable(
                            it1, R.drawable.jm_asc_button_icon)
                    })
                }
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
        var altText = ""
        for (i in manga.attributes.altTitles) {
            if (i.en != "null" && i.en != null) {
                altText += i.en + ", "
            }
            if (i.ja != "null" && i.ja != null) {
                altText += i.ja + ", "
            }
        }
        var genresText: String = ""
        for (i in manga.attributes.tags) {
            genresText += i.attributes.name.en
            genresText += ", "
        }
        with(binding) {
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