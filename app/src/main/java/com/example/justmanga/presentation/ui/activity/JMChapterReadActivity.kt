package com.example.justmanga.presentation.ui.activity

import android.animation.ObjectAnimator
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.justmanga.R
import com.example.justmanga.databinding.ChapterReadSettingsDialogBinding
import com.example.justmanga.databinding.JmActivityChapterReadBinding
import com.example.justmanga.presentation.adapter.JMChapterReadPagerAdapter
import com.example.justmanga.presentation.utils.Utils
import com.example.justmanga.presentation.vm.JMChapterReadActivityVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class JMChapterReadActivity : FragmentActivity() {

    private lateinit var mPager: ViewPager2

    private lateinit var binding: JmActivityChapterReadBinding

    private var footerAndHeaderShown: Boolean = true

    private lateinit var footerHideAnimation: ObjectAnimator
    private lateinit var footerShowAnimation: ObjectAnimator
    private lateinit var headerHideAnimation: ObjectAnimator
    private lateinit var headerShowAnimation: ObjectAnimator

    private lateinit var hideTimer: CountDownTimer

    private var chapterPageCount: Int = 0

    private val vm: JMChapterReadActivityVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JmActivityChapterReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTimer()
        setListeners()
        initViewPager()
        setHeaderAndFooterAnimations()
        getChapterPagesLinks()

    }

    private fun initTimer() {
        hideTimer = object: CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                footerAndHeaderShown = false
                footerHideAnimation.start()
                headerHideAnimation.start()
            }
        }
        hideTimer.start()
    }

    private fun setListeners() = with(binding){
        backBtn.setOnClickListener { finish() }
        settingsBtn.setOnClickListener { openSettingsDialog() }
    }

    private fun openSettingsDialog() {
        val binding: ChapterReadSettingsDialogBinding = ChapterReadSettingsDialogBinding.inflate(layoutInflater);
        val alertDialog = Dialog(this@JMChapterReadActivity)
        alertDialog.setContentView(binding.root)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        alertDialog.show()
    }

    private fun setChapterInfo() = with(binding){
        chapterNumbTV.text = "Chapter ${intent.getStringExtra("chapterNumb")}"
        pageNumbTV.text = "1/${chapterPageCount}"
    }

    private fun setHeaderAndFooterAnimations() {
        footerHideAnimation = ObjectAnimator.ofFloat(binding.footer, "translationY", 0f, Utils.dpToPx(this, FOOTER_AND_HEADER_HEIGHT))
        footerShowAnimation = ObjectAnimator.ofFloat(binding.footer, "translationY", Utils.dpToPx(this, FOOTER_AND_HEADER_HEIGHT), 0f)
        headerHideAnimation = ObjectAnimator.ofFloat(binding.header, "translationY", 0f, -Utils.dpToPx(this, FOOTER_AND_HEADER_HEIGHT))
        headerShowAnimation = ObjectAnimator.ofFloat(binding.header, "translationY", -Utils.dpToPx(this, FOOTER_AND_HEADER_HEIGHT), 0f)
    }

    private fun initViewPager() {
        mPager = binding.pager
        vm.chaptersImagesLiveData.observe(this){
            val pagerAdapter = JMChapterReadPagerAdapter(this, it.chapter.data, it.chapter.hash, ::clickListener)
            mPager.adapter = pagerAdapter

            chapterPageCount = it.chapter.data.count()
            setChapterInfo()
        }
    }


    private fun clickListener(){
        footerAndHeaderShown = if(footerAndHeaderShown){
            hideTimer.cancel()
            footerShowAnimation.cancel()
            footerHideAnimation.start()
            headerShowAnimation.cancel()
            headerHideAnimation.start()
            false
        }else{
            hideTimer.start()
            footerHideAnimation.cancel()
            footerShowAnimation.start()
            headerHideAnimation.cancel()
            headerShowAnimation.start()
            true
        }

    }

    private fun getChapterPagesLinks() {
        vm.getChaptersImages(intent.getStringExtra("chapterId").toString())
    }

    companion object{
        private const val FOOTER_AND_HEADER_HEIGHT = 65
    }
}