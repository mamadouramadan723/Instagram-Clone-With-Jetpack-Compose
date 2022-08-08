package com.rmd.media.instacloneapp.repository

import com.rmd.media.instacloneapp.model.User
import com.rmd.media.instacloneapp.model.names

class StoryRepository {
    fun getAllStories(): List<User> {
        val users = ArrayList<User>()
        (0..9).forEach { index ->
            val user = User(
                id = names[index],
                name = names[index],
                imgUrl = "https://randomuser.me/api/portraits/men/${index + 1}.jpg"
            )
            users.add(user)
        }
        return users
    }
}