package ru.neotology

class Post(
    var id: Int,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val published: Long,
    likes: Int,
) {
    var likes = likes
        set(value) {
            if (value >= 0) {
                field = value
            }
        }

}

fun main() {

    val post = Post(1, 1, "author", "content", likes = 0, published = 0)
    post.likes = -100
    println(post.likes)

}