package pe.edu.upc.recipeapp.features.books.presentation

import pe.edu.upc.recipeapp.features.books.domain.Book

data class BooksUiState(
    val books: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
