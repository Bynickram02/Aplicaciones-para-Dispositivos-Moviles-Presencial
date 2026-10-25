package pe.edu.upc.recipeapp.main

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import pe.edu.upc.recipeapp.R
import pe.edu.upc.recipeapp.core.designsystems.book
import pe.edu.upc.recipeapp.core.designsystems.bookmark

enum class NavigationItem(
    val route: @Serializable Any,
    val icon: ImageVector,
    val title: Int
) {
    BOOKS(
        route = BooksRoute,
        icon = book,
        title = R.string.tab_books
    ),
    LIBRARY(
        route = LibraryRoute,
        icon = bookmark,
        title = R.string.tab_library
    )
}
