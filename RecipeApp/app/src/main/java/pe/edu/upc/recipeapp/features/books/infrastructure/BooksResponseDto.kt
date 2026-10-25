package pe.edu.upc.recipeapp.features.books.infrastructure

data class BooksResponseDto(
    val count: Int,
    val results: List<BookDto>
)
