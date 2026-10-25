package pe.edu.upc.recipeapp.features.library.infrastructure

import pe.edu.upc.recipeapp.features.library.domain.LibraryBook

fun LibraryBookEntity.toDomain(): LibraryBook {
    return LibraryBook(
        id = this.id,
        title = this.title,
        author = this.author,
        cover = this.cover,
        year = this.year,
        readDate = this.readDate
    )
}

fun LibraryBook.toEntity(): LibraryBookEntity {
    return LibraryBookEntity(
        id = this.id,
        title = this.title,
        author = this.author,
        cover = this.cover,
        year = this.year,
        readDate = this.readDate
    )
}
