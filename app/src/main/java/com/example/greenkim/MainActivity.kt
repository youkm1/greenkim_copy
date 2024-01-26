package com.example.greenkim

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

import com.example.greenkim.ui.theme.GreenKimTheme
import com.example.greenkim.ui.theme.lineKorFamily


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenKimTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(Color.White)) {
        TopMainScreen()
        Spacer(modifier = modifier.size(20.dp))
        CommunitySection()
        Spacer(modifier = modifier.size(40.dp))
        ZeroTodoSection()
    }

}


@Composable
fun TopMainScreen(modifier: Modifier = Modifier) {
    Row(Modifier.padding(20.dp)) {
        //대표뱃지는 300x300
        Image(painter = painterResource(id = R.drawable.badge), contentDescription = "badge")
        Column(Modifier.padding(top = 30.dp, start = 10.dp)) {
            Text(
                "프로 기타리스트 송이님",
                color = Color(0xFF22C571),
                fontFamily = lineKorFamily,
                fontWeight = Bold,
                fontSize = 20.sp,
                letterSpacing = 2.sp,
            )
            Text(
                text = "어떤 하루를 보내고 계신가요?",
                fontFamily = lineKorFamily,
                fontWeight = Thin,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun CommunitySection() {
    val context = LocalContext.current
    Spacer(modifier = Modifier.size(30.dp))


    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
    ) {
        Text(text = "김그린 인기글", fontSize = 30.sp, fontFamily = lineKorFamily)
        IconButton(
            onClick =
            {
                val intent = Intent(context, CommunityActivity::class.java)
                startActivity(context, intent, null)
            },
            modifier = Modifier
                .padding(start = 160.dp)
                .size(20.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowForward, contentDescription = null,
            )

        }

    }
    Spacer(modifier = Modifier.size(5.dp))
    Divider(
        color = Color.Black, modifier = Modifier
            .size(height = 1.dp, width = 200.dp)
            .padding(start = 30.dp)
    )
    Spacer(modifier = Modifier.size(10.dp))
    Column(modifier = Modifier.padding(start = 30.dp)) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "오늘 밤 진짜 너무 춥다 날씨 실화냐 버스 타고 집 오는데 도로...",
                fontFamily = lineKorFamily,
                fontSize = 18.sp
            )
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "서울역 근처 제로웨이스트 샵 추천 간다 ㅋ", fontFamily = lineKorFamily, fontSize = 18.sp)
        }


        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "[서울 비건 활동 모임]- 관심 있는 그린이들 어서 오세요 마감일...",
                fontFamily = lineKorFamily,
                fontSize = 18.sp
            )

        }
    }

}

@Composable
fun ZeroTodoSection() {
    val context = LocalContext.current

    Spacer(modifier = Modifier.size(25.dp))
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 30.dp)
    ) {
        Spacer(modifier = Modifier.size(15.dp))
        Row {
            Text(text = "오늘의 제로웨이스트 활동", fontFamily = lineKorFamily, fontSize = 30.sp)
            IconButton(
                onClick =
                {
                    val intent = Intent(context, CommunityActivity::class.java)
                    intent.putExtra("fragmentToLoad", "ProofFragment")
                    startActivity(context, intent, null)
                },
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(20.dp)
            )
            {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        ZeroActivities()
    }
}

@Composable
fun ZeroActivities() {
    val context = LocalContext.current
    LazyRow() {
        item(7) {
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "전자영수증 발급받기")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.e_receipt),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "전자영수증",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "리유저블 활동")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.reuse),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "리유저블 활동",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "플라스틱 프리")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.plastic_free),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "플라스틱 프리",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "리폼")
                    intent.putExtra("selectedBoard", "플로깅")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.plogging),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "플로깅",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "리폼")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.reform),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "리폼",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "대중교통 자전거")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.transport),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "대중교통",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            FilledIconButton(
                onClick = {
                    val intent = Intent(context, CheckPostActivity::class.java)
                    intent.putExtra("selectedBoard", "기타")
                    startActivity(context, intent, null)
                },
                modifier =
                Modifier
                    .padding(end = 12.dp)
                    .size(100.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.etc),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                    )
                    Text(
                        text = "기타",
                        fontFamily = lineKorFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    GreenKimTheme {
        MainScreen()
    }
}