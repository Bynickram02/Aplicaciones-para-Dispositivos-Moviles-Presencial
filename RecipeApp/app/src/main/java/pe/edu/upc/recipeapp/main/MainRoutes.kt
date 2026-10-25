package pe.edu.upc.recipeapp.main

import kotlinx.serialization.Serializable

@Serializable
data object OnboardingRoute

@Serializable
data object MainRoute

@Serializable
data class BookDetailRoute(val bookId: Int)

@Serializable
data object BooksRoute

@Serializable
data object LibraryRoute
