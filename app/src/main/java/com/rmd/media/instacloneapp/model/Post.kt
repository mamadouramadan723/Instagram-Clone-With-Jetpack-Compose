package com.rmd.media.instacloneapp.model

import androidx.compose.runtime.Immutable

@Immutable
data class Post(
    val id: String,
    val imgUrl: String,
    val caption: String,
    val user: User,
    val likesCount: Int,
    val timeStamp: Long,
    val comments: List<Comment>
)

