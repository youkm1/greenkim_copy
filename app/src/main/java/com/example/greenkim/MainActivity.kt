package com.example.greenkim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column {
        TopScreen()
        Spacer(modifier = modifier.size(20.dp))
        CommunitySection()
        Spacer(modifier = modifier.size(40.dp))
        ZeroTodoSection()
    }

}


@Composable
fun TopScreen(modifier: Modifier = Modifier) {
    Row(Modifier.padding(20.dp)) {
        //대표뱃지는 300x300
        Image(painter = painterResource(id = R.drawable.badge), contentDescription = "logo")
        Column(Modifier.padding(top = 30.dp, start = 10.dp)) {
            Text(
                "프로 기타리스트 송이님",
                color = Color(0xFF22C571),
                fontFamily = lineKorFamily,
                fontWeight = Bold,
                fontSize = 20.sp
            )
            Text(text = "어떤 하루를 보내고 계신가요?", fontWeight = FontWeight.Bold)
        }

    }
}

@Composable
fun CommunitySection() {
    Spacer(modifier = Modifier.size(30.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
    ) {
        Text(text = "김그린 인기글")
        Icon(
            imageVector = Icons.Filled.ArrowForward, contentDescription = null, modifier = Modifier
                .padding(start = 240.dp)
                .size(20.dp)
        )
    }
    Spacer(modifier = Modifier.size(10.dp))
    OutlinedCard(Modifier.fillMaxWidth()) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "오늘 밤 진짜 너무 춥다 날씨 실화냐 버스 타고 집 오는데 도로...")
        }


        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "서울역 근처 제로웨이스트 샵 추천 간다 ㅋ")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "[서울 비건 활동 모임]- 관심 있는 그린이들 어서 오세요 마감일...")
        }
    }

}

@Composable
fun ZeroTodoSection() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
    ) {
        Row {
            Text(text = "오늘의 제로웨이스트 활동")
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 160.dp)
                    .size(20.dp)
            )

        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            zerobtns()
            zerobtns()
            zerobtns()
        }

    }
}

@Composable
fun zerobtns() {
    Column {
        FilledIconButton(
            onClick = { /*TODO*/ },
            modifier =
            Modifier
                .size(80.dp),
            colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.e_receipt),
                contentDescription = null
            )

        }
        Text(
            text = "전자영수증"
        )
    }
}

@Composable
fun LazyRowEx() {
    LazyRow(
        modifier = Modifier
            .padding(16.dp)
    ) {
        items(7) { index ->
            FilledIconButton(
                modifier =
                Modifier
                    .padding(10.dp)
                    .size(80.dp),
                colors = IconButtonDefaults.filledIconButtonColors(Color(0xFFC7E6BF)),
                onClick = {
                    when (index) {
                        0 -> {

                        }

                        1 -> {

                        }

                        2 -> {

                        }

                        3 -> {

                        }

                        4 -> {

                        }

                        5 -> {

                        }

                        6 -> {

                        }

                        7 -> {

                        }
                    }
                },
                )
            {
        
            Icon(painter = painterResource(id = R.drawable.e_receipt), contentDescription = null)
                Icon(painter = painterResource(id = R.drawable.frog), contentDescription = null)


            }


        }
    }

}

@Composable
fun btns(icons: ImageVector) {
    Image(painter = painterResource(id = R.drawable.e_receipt), contentDescription = null)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GreenKimTheme {
        MainScreen()
    }
}

@Preview(showSystemUi = true)
@Composable
fun preLazo() {
    LazyRowEx()
}
