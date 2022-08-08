package com.rmd.media.instacloneapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.rmd.media.instacloneapp.R
import com.rmd.media.instacloneapp.component.Posts
import com.rmd.media.instacloneapp.component.Stories
import com.rmd.media.instacloneapp.repository.PostRepository
import com.rmd.media.instacloneapp.repository.StoryRepository

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val storyRepository = StoryRepository()
    val allStories = storyRepository.getAllStories()
    
    val postRepository = PostRepository()
    val allPosts = postRepository.getAllPosts()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column {
            AppBar()
            Divider(color = Color.White)
            Stories(storyList = allStories)
            Divider(color = Color.White)
            Posts(postList = allPosts)
        }
    }
}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
    ) {
        Image(
            alignment = Alignment.TopStart,
            modifier = modifier.size(128.dp),
            contentDescription = "Insta Logo",
            painter = painterResource(id = R.drawable.insta_logo)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopEnd)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest
                        .Builder(context)
                        .crossfade(true)
                        .data("https://img.icons8.com/fluency-systems-regular/60/ffffff/plus-2-math.png")
                        .build(),
                    filterQuality = FilterQuality.High
                ),
                contentScale = ContentScale.Fit,
                contentDescription = "Add Button",
                modifier = modifier
                    .size(32.dp)
                    .wrapContentWidth()
                    .clip(shape = CircleShape)
            )
        }
    }
}