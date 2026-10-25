package pe.edu.upc.recipeapp.features.bookdetail.presentation

import pe.edu.upc.recipeapp.features.books.domain.Book

data class BookDetailUiState(
    val book: Book? = null,
    val isRead: Boolean = false,
    val readDate: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
