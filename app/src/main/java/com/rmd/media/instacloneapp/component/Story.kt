package com.rmd.media.instacloneapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.rmd.media.instacloneapp.model.User

@Composable
fun StoryRowItem(userStory: User) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .size(width = 80.dp, height = 100.dp)
            .padding(horizontal = 5.dp),
        backgroundColor = Color.Black,
        elevation = 12.dp,
        shape = RoundedCornerShape(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(context)
                        .crossfade(true)
                        .data(userStory.imgUrl)
                        .build(),
                    filterQuality = FilterQuality.High
                ),
                contentDescription = "userImgUrl",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .size(64.dp)
                    .clip(shape = CircleShape)
            )
            Text(text = userStory.name, color = Color.White, maxLines = 1)
        }
    }
}

@Composable
fun Stories(storyList: List<User>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp)
    ) {
        LazyRow(
            state = rememberLazyListState(),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 5.dp)
        ) {
            items(items = storyList) { item ->
                StoryRowItem(userStory = item)
            }
        }
    }
}