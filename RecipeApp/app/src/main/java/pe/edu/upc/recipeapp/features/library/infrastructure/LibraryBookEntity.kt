package pe.edu.upc.recipeapp.features.library.infrastructure

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "library_books")
data class LibraryBookEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val author: String,
    val cover: String,
    val year: Int,
    val readDate: String
)
