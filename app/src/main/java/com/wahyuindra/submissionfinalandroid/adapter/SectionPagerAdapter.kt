package com.wahyuindra.submissionfinalandroid.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wahyuindra.submissionfinalandroid.utils.ARG_SECTIONS_NUMBER
import com.wahyuindra.submissionfinalandroid.views.fragment.HomeFragment
import com.wahyuindra.submissionfinalandroid.views.fragment.MessageFragment


class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> HomeFragment()
            1 -> MessageFragment()
            else -> Fragment()
        }

        fragment.arguments = Bundle().apply {
            putInt(ARG_SECTIONS_NUMBER, position + 1)
        }
        return fragment
    }

    override fun getItemCount(): Int = 2

}