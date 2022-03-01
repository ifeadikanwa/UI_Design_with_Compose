package com.ifyezedev.uidesignwithcompose

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifyezedev.uidesignwithcompose.ui.theme.*

class Feed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIDesignWithComposeTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun FeedScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Feed",
                style = MaterialTheme.typography.h3.copy(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            
            Spacer(modifier = Modifier.height(10.dp))

            ProgressNotice(progressStatus = ProgressStatus.GOOD)

            Posts()
        }
    }

}

@Composable
fun Posts() {
    LazyColumn(){
        items(count = 5){
            Post()
        }
    }
}

@Composable
fun Post() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.post_img),
                modifier = Modifier.fillMaxWidth(),
                contentDescription = "post image",
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Weekly Progress",
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                
                Likes()
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Weekly progress on exercising.",
                style = MaterialTheme.typography.body1.copy(fontSize = 14.sp)
            )
        }
    }
}

@Composable
fun Likes() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "likes",
            tint = Grey,
            modifier = Modifier.size(15.dp)
        )
        
        Spacer(modifier = Modifier.width(4.dp))
        
        Text(
            text = "42 likes",
            style = MaterialTheme.typography.body1.copy(fontSize = 14.sp)
        )
    }

}

@Composable
fun ProgressNotice(progressStatus: ProgressStatus){
    Card(
        backgroundColor = progressStatus.color,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
        modifier = Modifier.padding(vertical = 10.dp)
        ) {
        Row(
            modifier = Modifier.padding(25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                ProgressNoticeHeading()
                
                Spacer(modifier = Modifier.height(10.dp))
                
                ProgressNoticeText(progressStatus = progressStatus)
            }
            
            Spacer(modifier = Modifier.width(20.dp))

            OkButton()
        }
    }
}

@Composable
fun OkButton() {
    Box(contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.4f))
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
        Text(text = "ok", color = Green)
    }
}

@Composable
fun ProgressNoticeText(progressStatus: ProgressStatus) {
    if(progressStatus == ProgressStatus.GOOD){
        Text(
            text = "It looks like you are on track. Please continue to follow your daily plan.",
            style = MaterialTheme.typography.body1.copy(
                color = Color.White
            )
        )
    }
    else {
        Text(
            text = "It looks like you are currently not on track. Please continue to follow your daily plan, you've got this!",
            style = MaterialTheme.typography.body1.copy(
                color = Color.White
            )
        )

    }

}

@Composable
fun ProgressNoticeHeading() {
    Row() {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White.copy(alpha = 0.4f), RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center

        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "star",
                modifier = Modifier.padding(5.dp),
                tint = Color.White
            )
        }
        
        Spacer(modifier = Modifier.width(20.dp))
        
        Column() {
            Text(
                text = "Weekly",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
            Text(
                text = "Progress",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }
        
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewDark() {
    UIDesignWithComposeTheme(darkTheme = true) {
        FeedScreen()
    }
}

enum class ProgressStatus(val color: Color) {
    GOOD(Green),
    BAD(Red)
}