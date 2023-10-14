package ru.neotology

data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val published: Long,
    val likes: Int,
)

object WallService { //Singletone

    private var posts = emptyArray<Post>() //создаем массив для хранения постов
    fun add(post: Post): Post {
        posts += post // добавляем в массив и возвращаем последний элемент.
        return posts.last()

    }

    fun likeById(id: Int) { //ищем по id

        for ((index, post) in posts.withIndex()) {

            if (post.id == id) {

                posts[index] = post.copy(likes = post.likes + 1)

            }
        }
    }



}

fun main() {

    val post = Post(1, 1, "author", "content", likes = 0, published = 0)
    val liked = post.copy(likes = post.likes + 1) //создаем копию класса и указываем только измененные параметры!
    //data классы предоставляют встроеннуюб функцию преобразования в строку
    //Post(id=1, authorId=1, authorName=author, content=content, published=0, likes=1)
    val (id, authorId, _, content) = post //получаем значения нужных полей (деструктуризация),
    //если поле не надо получать, ставим "_"
    println(liked)
    println("$id, $authorId, $content") //выводим полученные значения.
}