package com.example.greenkim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public enum class BadgeList (
    val badge:String,
    val badgeNum:Int,
    val badgeImg:Int
){
    BLANK("",-1,-1),
    MENTOR("그린 멘토",5,R.drawable.mentor),
    MENTEE("그린 멘티",5,R.drawable.mentee),
    EARLYBIRD("얼리버드",3,R.drawable.earlybird),
    NORANG("김노랑",10,R.drawable.norang),
    YEONDU("김연두",20,R.drawable.yeondu),
    GREEN("김그린",50,R.drawable.green),
    RECEIPT_3("영수증도 전자로",3,R.drawable.electronic_receipt),
    RECEIPT_10("디지털 환경 지킴이",10,R.drawable.digital_protector),
    REUSABLE_3("re: user",3,R.drawable.re_user),
    REUSABLE_10("re: 마스터",10,R.drawable.re_master),
    PLASTIC_3("자연과 친구하기",3,R.drawable.eco_friend),
    PLASTIC_10("자연과 물아일체",10,R.drawable.eco_one),
    PLOGGING_3("자연 속에 만 보 추구",3,R.drawable.jamanchu),
    PLOGGING_10("클린로드의 개척자",10,R.drawable.clean_road),
    REFORM_3("손재주 아티스트",3,R.drawable.artist),
    REFORM_10("친환경 대가",10,R.drawable.eco_master),
    TRANSPORT_3("탄소 헤이터",3,R.drawable.c_hater),
    TRANSPORT_10("지구 세이버",10,R.drawable.e_saver),
    ETC_3("아마추어 기타리스트",3,R.drawable.amateur_guitarist),
    ETC_10("프로 기타리스트",10,R.drawable.pro_guitarist),
    ADVENTURER("환경 모험가",-1,R.drawable.adventurer),
    DOCTOR("김그린 박사",-1,R.drawable.doctor),
    GOLDEN_KIMGREEN("황금 김그린",-1,R.drawable.golden_kimgreen)
}

// RecyclerView 어댑터
class BadgeAdapter(private val badgeList: List<BadgeList>, private val listener: (BadgeList) -> Unit) :
    RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder>() {

    inner class BadgeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val badgeImg: ImageView = itemView.findViewById(R.id.badge_image)
        val badge: TextView = itemView.findViewById(R.id.badge_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.badge_layout, parent, false)
        return BadgeViewHolder(view)
    }

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) {
        val currentItem = badgeList[position]

        holder.badge.text = currentItem.badge
        holder.badgeImg.setImageResource(currentItem.badgeImg)

        // 뱃지 클릭 시 해당 뱃지 정보 전달
        holder.itemView.setOnClickListener {
            listener(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return badgeList.size
    }
}