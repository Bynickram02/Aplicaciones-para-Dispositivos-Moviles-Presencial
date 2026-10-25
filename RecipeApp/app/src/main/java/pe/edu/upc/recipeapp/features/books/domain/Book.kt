package pe.edu.upc.recipeapp.features.books.domain

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val cover: String,
    val publisher: String,
    val year: Int,
    val rating: Double,
    val genre: String,
    val overview: String
)
