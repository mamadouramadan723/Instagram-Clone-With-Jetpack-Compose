package com.rmd.media.instacloneapp.repository

import android.util.Log
import com.github.javafaker.Faker
import com.rmd.media.instacloneapp.model.Comment
import com.rmd.media.instacloneapp.model.Post
import com.rmd.media.instacloneapp.model.User
import com.rmd.media.instacloneapp.model.names

class PostRepository {
    var faker: Faker = Faker()


    fun getAllPosts(): List<Post> {
        val posts = ArrayList<Post>()
        (0..9).forEach { index ->
            var comments = listOf(
                Comment(
                    "comment $index",
                    faker.shakespeare().kingRichardIIIQuote().toString()
                ), Comment(
                    "comment $index",
                    faker.shakespeare().kingRichardIIIQuote().toString()
                ),
                Comment("comment $index",
                    faker.shakespeare().kingRichardIIIQuote().toString()
                )
            )
            val post = Post(
                id = "${index + 1}",
                imgUrl = "https://source.unsplash.com/random/400x300?$index",
                user = User(
                    id = names[index],
                    name = names[index],
                    imgUrl = "https://randomuser.me/api/portraits/men/${index + 1}.jpg"
                ),
                likesCount = index + 100,
                caption = "caption $index",
                timeStamp = System.currentTimeMillis() - (index * 60000),
                comments = comments
            )

            posts.add(post)
        }
        return posts
    }
}
