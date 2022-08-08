package com.rmd.media.instacloneapp.component

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.rmd.media.instacloneapp.model.Post
import com.rmd.media.instacloneapp.R

@Composable
fun PostColumnItem(post: Post) {
    val context = LocalContext.current
    val like: String = when (post.likesCount) {
        0 -> ""
        1 -> "Like"
        else -> "Likes"
    }


    //Owner Image Profile + More Button
    Row(modifier = Modifier.wrapContentWidth()) {

        //Post Owner Image Profile
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(context)
                    .crossfade(true)
                    .data(post.user.imgUrl)
                    .build(),
                filterQuality = FilterQuality.High
            ),
            contentDescription = "postOwnerImgUrl",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape)
        )
        //Post Owner User Name
        Text(
            text = post.user.name,
            color = Color.White,
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterVertically)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopEnd)
        ) {
            Image(
                painterResource(R.drawable.ic_more),
                contentDescription = "Like Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .size(32.dp)
                    .clip(shape = CircleShape)
            )
        }
    }
    Spacer(modifier = Modifier.height(5.dp))
    Image(
        painter = rememberAsyncImagePainter(
            model = ImageRequest
                .Builder(context)
                .crossfade(true)
                .data(post.imgUrl)
                .build(),
            filterQuality = FilterQuality.High
        ),
        contentDescription = "Post Image",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    )
    //3 buttons : like, comment, share
    Row() {
        Image(
            painterResource(R.drawable.ic_like),
            contentDescription = "Like Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape)
        )
        Image(
            painterResource(R.drawable.speech),
            contentDescription = "Comment Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape)
        )
        Image(
            painterResource(R.drawable.share),
            contentDescription = "Share Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .size(32.dp)
                .clip(shape = CircleShape)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopEnd)
        ) {
            Image(
                painterResource(R.drawable.bookmark),
                contentDescription = "BookMark Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .size(32.dp)
                    .clip(shape = CircleShape)
            )
        }
    }
    Text(text = "${post.likesCount} $like", color = Color.White, fontSize = 12.sp)
    Row() {
        Text(
            text = post.user.name,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = post.caption,
            color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(2.dp)
        )
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        val comments = post.comments

        if (comments.isEmpty()) {
            Text(
                text = "no comments yet",
                color = Color.White,
                fontSize = 12.sp,
            )
        } else if (comments.size == 1) {
            Text(
                text = "View 1 Comment",
                color = Color.White,
                fontSize = 12.sp,
            )
        } else {
            Text(
                text = "View all ${comments.size} Comments",
                color = Color.White,
                fontSize = 12.sp,
            )
        }
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
fun Posts(postList: List<Post>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 5.dp, bottom = 10.dp)
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 5.dp)
        ) {
            items(items = postList) { item ->
                PostColumnItem(post = item)
            }
        }
    }
}