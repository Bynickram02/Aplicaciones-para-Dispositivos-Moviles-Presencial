package pe.edu.upc.recipeapp.features.library.domain

data class LibraryBook(
    val id: Int,
    val title: String,
    val author: String,
    val cover: String,
    val year: Int,
    val readDate: String
)
