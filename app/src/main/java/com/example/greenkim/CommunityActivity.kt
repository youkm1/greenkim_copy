package com.example.greenkim

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.greenkim.databinding.ActivityCommunityBinding
import com.google.android.material.tabs.TabLayoutMediator

class CommunityActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCommunityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentToLoad = intent.getStringExtra("fragmentToLoad")

        val fragmentList = listOf(CommunityFragment(), ConfirmationFragment())

        val adapter_fragment = FragmentAdapter(this)
        adapter_fragment.fragmentList = fragmentList

        binding.viewPager.adapter = adapter_fragment

        val tabTitles = listOf<String>("Community", "Proof")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        fragmentToLoad?.let {
            if (it == "ComfirmationFragment") {
                binding.viewPager.currentItem = 1
            }
        }

        val buttonHome = findViewById<ImageButton>(R.id.button_language)
        buttonHome.setColorFilter(Color.parseColor("#288156"), android.graphics.PorterDuff.Mode.SRC_IN)

    }
}
