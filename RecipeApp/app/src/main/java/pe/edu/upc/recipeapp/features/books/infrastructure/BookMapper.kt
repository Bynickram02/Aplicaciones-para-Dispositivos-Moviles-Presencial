package pe.edu.upc.recipeapp.features.books.infrastructure

import pe.edu.upc.recipeapp.features.books.domain.Book

fun BookDto.toDomain(): Book {
    return Book(
        id = this.id,
        title = this.title,
        author = this.author,
        cover = this.cover,
        publisher = this.publisher,
        year = this.year,
        rating = this.rating,
        genre = this.genre,
        overview = this.overview
    )
}
