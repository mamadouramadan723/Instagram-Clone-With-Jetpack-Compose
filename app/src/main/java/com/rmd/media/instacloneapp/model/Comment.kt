package com.rmd.media.instacloneapp.model

import androidx.compose.runtime.Immutable

@Immutable
data class Comment(
    val id: String,
    val text: String
)
