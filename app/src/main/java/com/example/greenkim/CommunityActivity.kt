package com.example.greenkim

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.greenkim.databinding.ActivityCommunityBinding
import com.google.android.material.tabs.TabLayoutMediator

class CommunityActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCommunityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentToLoad = intent.getStringExtra("fragmentToLoad")

        val fragmentList = listOf(CommunityFragment(), ConfirmationFragment())

        val adapterFragment = FragmentAdapter(this)
        adapterFragment.fragmentList = fragmentList

        binding.viewPager.adapter = adapterFragment

        val tabTitles = listOf<String>("Community", "Proof")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        fragmentToLoad?.let {
            if (it == "ComfirmationFragment") {
                binding.viewPager.currentItem = 1
            }
        }

        val naviFragment = NaviFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, naviFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        val buttonLanguage = findViewById<ImageButton>(R.id.button_language)
        buttonLanguage.setColorFilter(Color.parseColor("#288156"), android.graphics.PorterDuff.Mode.SRC_IN)

    }
}
