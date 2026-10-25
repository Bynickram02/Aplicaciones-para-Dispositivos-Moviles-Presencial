package pe.edu.upc.recipeapp.features.library.presentation

import pe.edu.upc.recipeapp.features.library.domain.LibraryBook

data class LibraryUiState(
    val books: List<LibraryBook> = emptyList()
)
