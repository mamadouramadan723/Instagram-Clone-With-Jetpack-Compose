package com.rmd.media.instacloneapp.screen

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rmd.media.instacloneapp.R

@Composable
fun NewPost() {
    var imgUrl: MutableState<String> = remember {
        mutableStateOf("")
    }
    var caption: MutableState<String> = remember {
        mutableStateOf("")
    }

    Surface(color = Color.Black) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(50.dp)
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(R.drawable.left),
                    contentDescription = "Left Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .wrapContentWidth()
                        .size(32.dp)
                        .align(Alignment.CenterVertically)
                        .clip(shape = CircleShape)
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "New Post",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.TopEnd)
                ) {
                    Image(
                        painterResource(R.drawable.ic_check),
                        contentDescription = "Left Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .wrapContentWidth()
                            .size(32.dp)
                            .align(Alignment.CenterVertically)
                            .clip(shape = CircleShape)
                    )
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

        }

    }
}