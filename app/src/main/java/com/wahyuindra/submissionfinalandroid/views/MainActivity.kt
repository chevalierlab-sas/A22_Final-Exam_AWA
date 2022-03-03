package com.wahyuindra.submissionfinalandroid.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import com.wahyuindra.submissionfinalandroid.R
import com.wahyuindra.submissionfinalandroid.adapter.SectionPagerAdapter
import com.wahyuindra.submissionfinalandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_1,
            R.string.tab_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bindingTab = binding.tabs
        val bindingViewPager = binding.viewPager

        val sectionPagerAdapter = SectionPagerAdapter(this)
        bindingViewPager.adapter = sectionPagerAdapter

        TabLayoutMediator(bindingTab, bindingViewPager){ tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}