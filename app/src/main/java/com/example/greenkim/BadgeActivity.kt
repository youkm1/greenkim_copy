package com.example.greenkim

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BadgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)

        //뒤로가기
        val backButton: ImageButton = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val profileBadgeRecyclerView: RecyclerView = findViewById(R.id.profile_badge_recycler_view)
        val earnedBadgeRecyclerView: RecyclerView = findViewById(R.id.earned_badge_recycler_view)
        val unearnedBadgeRecyclerView: RecyclerView =
            findViewById(R.id.unearned_badge_recycler_view)

        // 각각의 RecyclerView에 대한 LayoutManager 설정
        val profileLayoutManager = GridLayoutManager(this, 5)
        val earnedLayoutManager = GridLayoutManager(this, 5)
        val unearnedLayoutManager = GridLayoutManager(this, 5)

        // Profile Badge 설정
        profileBadgeRecyclerView.layoutManager = profileLayoutManager
        val profileAdapter = BadgeAdapter(profileBadgeList) { clickedBadge ->
            showBadgePopup(clickedBadge)
        }
        profileBadgeRecyclerView.adapter = profileAdapter

        // Earned Badge 설정
        earnedBadgeRecyclerView.layoutManager = earnedLayoutManager
        val earnedAdapter = BadgeAdapter(earnedBadgeList) { clickedBadge ->
            showBadgePopup(clickedBadge)
        }
        earnedBadgeRecyclerView.adapter = earnedAdapter

        // Unearned Badge 설정
        unearnedBadgeRecyclerView.layoutManager = unearnedLayoutManager
        val unearnedAdapter = BadgeAdapter(badgeList) { clickedBadge ->
            showBadgePopup(clickedBadge)
        }
        unearnedBadgeRecyclerView.adapter = unearnedAdapter
    }

    // 뱃지 정보를 받아 팝업창에 표시하는 함수
    private fun showBadgePopup(badgeData: BadgeData) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.badge_popup_layout)

        val badgeImage = dialog.findViewById<ImageView>(R.id.popup_badge_image)
        val badgeText = dialog.findViewById<TextView>(R.id.popup_badge_text)
        val badgeAchievementText = dialog.findViewById<TextView>(R.id.badge_achievement)

        badgeImage.setImageResource(badgeData.badge_Image)
        badgeText.text = badgeData.badge_Text
        badgeAchievementText.text = badgeData.badge_Achievement_Text

        val closeButton = dialog.findViewById<ImageView>(R.id.popup_close_button)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
