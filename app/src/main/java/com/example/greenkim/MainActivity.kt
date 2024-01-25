package com.example.greenkim

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 인기글 버튼 클릭 시 CommunityActivity로 이동
        val communityButton = findViewById<Button>(R.id.communityButton)
        communityButton.setOnClickListener {
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("fragmentToLoad", "CommunityFragment")
            startActivity(intent)
        }

        // 제로웨이스트 활동 버튼 클릭 시 CommunityActivity로 이동
        val confirmationButton = findViewById<Button>(R.id.confirmationButton)
        confirmationButton.setOnClickListener {
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("fragmentToLoad", "ComfirmationFragment")
            startActivity(intent)
        }

        val btnEReceipt = findViewById<LinearLayout>(R.id.btn_e_receipt)
        btnEReceipt.setOnClickListener {
            navigateToCheckPostActivity("전자영수증 발급받기")
        }

        val btnReuse = findViewById<LinearLayout>(R.id.btn_reuse)
        btnReuse.setOnClickListener {
            navigateToCheckPostActivity("리유저블 활동")
        }

        val btnPlasticFree = findViewById<LinearLayout>(R.id.btn_plastic_free)
        btnPlasticFree.setOnClickListener {
            navigateToCheckPostActivity("플라스틱 프리")
        }

        val btnPlogging = findViewById<LinearLayout>(R.id.btn_plogging)
        btnPlogging.setOnClickListener {
            navigateToCheckPostActivity("플로깅")
        }

        val btnReform = findViewById<LinearLayout>(R.id.btn_reform)
        btnReform.setOnClickListener {
            navigateToCheckPostActivity("리폼")
        }

        val btnTransport = findViewById<LinearLayout>(R.id.btn_transport)
        btnTransport.setOnClickListener {
            navigateToCheckPostActivity("대중교통 자전거")
        }

        val btnEtc = findViewById<LinearLayout>(R.id.btn_etc)
        btnEtc.setOnClickListener {
            navigateToCheckPostActivity("기타")
        }
    }

    private fun navigateToCheckPostActivity(selectedBoard: String) {
        val intent = Intent(this, CheckPostActivity::class.java)
        intent.putExtra("selectedBoard", selectedBoard)
        startActivity(intent)
    }
}