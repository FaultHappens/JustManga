package com.example.justmanga.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.justmanga.data.dto.manga.response.JMMangaModel
import com.example.justmanga.databinding.JmFragmentMangaInfoBinding


class JMMangaInfoFragment : Fragment() {

    private lateinit var binding: JmFragmentMangaInfoBinding
    private lateinit var manga: JMMangaModel
    private lateinit var coverID: String
    private val args: JMMangaInfoFragmentArgs by navArgs<JMMangaInfoFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manga = args.mangaWithCoverModel.manga
        coverID = args.mangaWithCoverModel.coverID

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
        val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        var altText = ""
        for (i in manga.attributes.altTitles) {
            if (i.en != "null" && i.en != null) {
                altText += i.en + ", "
            }
            if (i.ja != "null"&& i.ja != null) {
                altText += i.ja + ", "
            }
        }
        var genresText: String = ""
        for(i in manga.attributes.tags){
            genresText += i.attributes.name.en
            genresText +=  ", "
        }
        with(binding){
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