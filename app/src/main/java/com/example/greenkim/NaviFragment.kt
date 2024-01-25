package com.example.greenkim

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class NaviFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_navi, container, false)

        val homeButton: ImageButton = view.findViewById(R.id.button_home)
        val languageButton: ImageButton = view.findViewById(R.id.button_language)
        val accountButton: ImageButton = view.findViewById(R.id.button_account)

        homeButton.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        languageButton.setOnClickListener {
            val intent = Intent(activity, CommunityActivity::class.java)
            startActivity(intent)
        }

        // 마지막 이미지는 클릭 이벤트를 냅둠

        return view
    }
}
