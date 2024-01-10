package com.example.greenkim

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.greenkim.databinding.ActivityCommunityBinding
import com.example.greenkim.databinding.FragmentComfirmationBinding
import com.google.android.material.tabs.TabLayoutMediator

class CommunityActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCommunityBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(ComfirmationFragment(),CommunityFragment())

        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList

        binding.viewPager.adapter = adapter

        val tabTitles = listOf<String>("Community","Proof")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}