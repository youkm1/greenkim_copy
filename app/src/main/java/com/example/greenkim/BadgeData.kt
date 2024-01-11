package com.example.greenkim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class BadgeData (
    val badge_Image:Int,
    val badge_Text:String,
    val badge_Achievement_Text:String
)

// RecyclerView 어댑터
class BadgeAdapter(private val badgeList: List<BadgeData>, private val listener: (BadgeData) -> Unit) :
    RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder>() {

    inner class BadgeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val badgeImage: ImageView = itemView.findViewById(R.id.badge_image)
        val badgeText: TextView = itemView.findViewById(R.id.badge_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.badge_layout, parent, false)
        return BadgeViewHolder(view)
    }

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) {
        val currentItem = badgeList[position]

        holder.badgeImage.setImageResource(currentItem.badge_Image)
        holder.badgeText.text = currentItem.badge_Text

        // 뱃지 클릭 시 해당 뱃지 정보 전달
        holder.itemView.setOnClickListener {
            listener(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return badgeList.size
    }
}


val badgeList=listOf(
    BadgeData(R.drawable.badge_mento,"그린 멘토","질문 카테고리 댓글 10회 작성하기"),
    BadgeData(R.drawable.badge_mentee,"그린 멘티","질문 카테고리 글 10회 작성하기"),
    BadgeData(R.drawable.badge_earlybird,"얼리버드","오전 9시 이전에 인증글 3회 작성"),
    BadgeData(R.drawable.badge_kimyellow,"김노랑","인증글 10회 작성하기"),
    BadgeData(R.drawable.badge_kimyellowgrin,"김연두","인증글 20회 작성하기"),
    BadgeData(R.drawable.badge_kimgreen,"김그린","인증글 50회 작성하기"),
    BadgeData(R.drawable.badge_receipt_1,"영수증도 전자로","전자영수증 발급 3회 인증하기"),
    BadgeData(R.drawable.badge_receipt_2,"디지털 환경 지킴이","전자영수증 발급 10회 인증하기"),
    BadgeData(R.drawable.badge_re_user,"re:user","리유저블 활동 3회 인증하기"),
    BadgeData(R.drawable.badge_re_master,"re:master","리유저블 활동 10회 인증하기"),
    BadgeData(R.drawable.badge_nature1,"자연과 친구하기","플라스틱 프리 3회 인증하기"),
    BadgeData(R.drawable.badge_nature2,"자연과 물아일체","플라스틱 프리 10회 인증하기"),
    BadgeData(R.drawable.badge_plogging_1,"자연 속에 만 보 추구","플로깅 3회 인증하기"),
    BadgeData(R.drawable.badge_plogging_2,"클린로드의 개척자","플로깅 10회 인증하기"),
    BadgeData(R.drawable.badge_reform_1,"손재주 아티스트","리폼 3회 인증하기"),
    BadgeData(R.drawable.badge_reform_2,"친환경 대가","리폼 10회 인증하기"),
    BadgeData(R.drawable.badge_bus_1,"탄소 헤이터","대중교통, 자전거 이용 3회 인증하기"),
    BadgeData(R.drawable.badge_bus_2,"지구 세이버","대중교통, 자전거 이용 10회 인증하기"),
    BadgeData(R.drawable.badge_guitar_1,"아마추어 기타리스트","기타 인증글 3회 작성하기"),
    BadgeData(R.drawable.badge_guitar_2,"프로 기타리스트","기타 인증글 10회 작성하기"),
    BadgeData(R.drawable.badge_adventurer,"환경 모험가","각 칵테고리별 인증글 1회 작성하기"),
    BadgeData(R.drawable.badge_doctor,"김그린 박사","튜토리얼 열람하기"),
    BadgeData(R.drawable.badge_gold,"황금 김그린","모든 뱃지 획득하기")
)

val earnedBadgeList=listOf(
    BadgeData(R.drawable.badge_mento,"그린 멘토","질문 카테고리 댓글 10회 작성하기"),
    BadgeData(R.drawable.badge_mentee,"그린 멘티","질문 카테고리 글 10회 작성하기"),
    BadgeData(R.drawable.badge_earlybird,"얼리버드","오전 9시 이전에 인증글 3회 작성"),
    BadgeData(R.drawable.badge_kimyellow,"김노랑","인증글 10회 작성하기"),
    BadgeData(R.drawable.badge_kimyellowgrin,"김연두","인증글 20회 작성하기"),
)

val profileBadgeList=listOf(
    BadgeData(R.drawable.unnamed_badge,"",""),
    BadgeData(R.drawable.unnamed_badge,"",""),
    BadgeData(R.drawable.unnamed_badge,"",""),
    BadgeData(R.drawable.unnamed_badge,"",""),
    BadgeData(R.drawable.unnamed_badge,"","")
)